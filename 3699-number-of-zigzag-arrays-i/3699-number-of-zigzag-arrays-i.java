class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // length = 2 initialization
        for (int a = 0; a < m; a++) {
            up[a] = a;               // smaller values before it
            down[a] = m - 1 - a;     // larger values before it
        }

        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long[] prefDown = new long[m + 1];
            long[] prefUp = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefDown[i + 1] =
                    (prefDown[i] + down[i]) % MOD;

                prefUp[i + 1] =
                    (prefUp[i] + up[i]) % MOD;
            }

            long totalUp = prefUp[m];

            for (int x = 0; x < m; x++) {

                // y < x
                newUp[x] = prefDown[x];

                // y > x
                newDown[x] =
                    (totalUp - prefUp[x + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}