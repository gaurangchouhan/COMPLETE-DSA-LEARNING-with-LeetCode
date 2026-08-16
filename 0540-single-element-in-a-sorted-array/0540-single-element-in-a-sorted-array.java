class Solution {
    public int singleNonDuplicate(int[] a) {
        int n  = a.length;
        if(n==1){
            return a[0];
        }
        return singleEle(a);
    }

    public int singleEle(int[] b){
        int n = b.length;
        int low = 0;
        int high = n-1;

        // while (low < high){
        //     int mid = (low + high)/2;

        //     int LHS = mid - low + 1;
        //     int RHS = high - (mid+1) + 1;

        //     // if(LHS == 3){
        //     //     if(b[high] == b[mid]){
        //     //         return b[low];
        //     //     }
        //     // }

        //     if(LHS % 2 != 0){
        //         high = mid;
        //     }
        //     else if(RHS % 2 != 0){
        //         low = mid+1;
        //     }
        // }

        while (low < high) {
            int mid = (low + high) / 2;

            // Make mid point to the first element of a pair (even index)
            if (mid % 2 == 1) {
                mid--; 
            }

            // Now mid is even; compare with its pair
            if (b[mid] == b[mid + 1]) {
                // Pair is intact → single element is on the right
                low = mid + 2;
            } else {
                // Pair is broken → single element is at mid or on the left
                high = mid;
            }
        }
        return b[low];
    }
}

// Concept: binary search 
// Time complexity: O(logN)
// Space complexity: O(1)