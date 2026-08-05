import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);

        for (int u = 0; u < n; u++) {
            if (suspicious[u]) continue;
            for (int v : graph.get(u)) {
                if (suspicious[v]) {
                    List<Integer> all = new ArrayList<>();
                    for (int i = 0; i < n; i++) all.add(i);
                    return all;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                res.add(i);
            }
        }
        return res;
    }

    private void dfs(int u, List<List<Integer>> graph, boolean[] suspicious) {
        suspicious[u] = true;
        for (int v : graph.get(u)) {
            if (!suspicious[v]) {
                dfs(v, graph, suspicious);
            }
        }
    }
}