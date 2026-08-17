 class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if ((long)mid*mid == (long)x) {
                return mid;
            } else if ((long)mid*mid < (long)x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return Math.round(high);
    }
}

// Concept: binary search 
// Time Complexity: O(logN)
// Space complexity: O(1)