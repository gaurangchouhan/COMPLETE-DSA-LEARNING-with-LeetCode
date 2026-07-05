import java.util.*;

class Solution {

    List<int[]>[] graph;
    List<Integer> topo;
    int n;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        n = online.length;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int[] indegree = new int[n];

        int maxCost = 0;

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxCost = Math.max(maxCost, e[2]);
        }

        // Topological Order
        topo = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {

            int u = q.poll();
            topo.add(u);

            for (int[] edge : graph[u]) {

                int v = edge[0];

                indegree[v]--;

                if (indegree[v] == 0)
                    q.offer(v);
            }
        }

        int low = 0;
        int high = maxCost;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, online, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit, boolean[] online, long k) {

        long INF = Long.MAX_VALUE / 4;

        long[] dp = new long[n];

        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int u : topo) {

            if (dp[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int cost = edge[1];

                if (cost < limit)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                if (dp[u] + cost < dp[v]) {
                    dp[v] = dp[u] + cost;
                }
            }
        }

        return dp[n - 1] <= k;
    }
}