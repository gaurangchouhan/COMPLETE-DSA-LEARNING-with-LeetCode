class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();

        int low = 1, high = maxPile;
        int ans = maxPile;

        while (low <= high) {
            int mid = (low + high) / 2;
            long totalH = calculateTotalHours(piles, mid);

            if (totalH <= h) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public long calculateTotalHours(int[] piles, int speed) {
        long totalH = 0;  // long to avoid overflow
        for (int bananas : piles) {
            totalH += (int)Math.ceil((double)bananas / speed);
        }
        return totalH;
    }

}

// Concept: Binary Search
// Time complexity: O(N*log(max(a[])))
// Space complexity: O(1)