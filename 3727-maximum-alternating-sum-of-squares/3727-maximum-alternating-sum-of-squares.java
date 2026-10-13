class Solution {
    public long maxAlternatingSum(int[] a) {
        int n = a.length;
        long[] sq = new long[n];

        for (int i = 0; i < n; i++) {
            sq[i] = (long) a[i] * a[i];
        }

        Arrays.sort(sq);

        int k = n / 2;
        long sum = 0;

        for (int i = k; i < n; i++) {
            sum += sq[i];
        }

        for (int i = 0; i < k; i++) {
            sum -= sq[i];
        }

        return sum;
    }
}

// Time complexity: O(nlogn)
// Space complexity: O(n)