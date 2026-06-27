import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {

        Arrays.sort(nums);

        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for (long x : freq.keySet()) {

            if (x == 1) continue;

            long cur = x;
            int len = 0;

            while (true) {

                Integer cnt = freq.get(cur);

                if (cnt == null) break;

                if (cnt == 1) {
                    len++;
                    break;
                }

                // Prevent overflow while squaring
                if (cur > 1000000000L / cur) {
                    len++;
                    break;
                }

                long next = cur * cur;

                if (!freq.containsKey(next)) {
                    len++;
                    break;
                }

                len += 2;
                cur = next;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}