class Solution {
    public int[] arrayRankTransform(int[] a) {
        int n = a.length;
        int[] copy = Arrays.copyOf(a, n);
        Arrays.sort(copy);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int i = 0; i < copy.length; i++) {
            int x = copy[i];
            if (!rankMap.containsKey(x)) {
                rankMap.put(x, rank++);
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = rankMap.get(a[i]);
        }
        return res;
    }
}
