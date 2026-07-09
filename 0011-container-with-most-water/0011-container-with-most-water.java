class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1;
        int maxArea = 0;

        while (l < r) {
            int height = Math.min(h[l], h[r]);
            int w = r - l;
            maxArea = Math.max(maxArea, height * w);

            if (h[l] < h[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}