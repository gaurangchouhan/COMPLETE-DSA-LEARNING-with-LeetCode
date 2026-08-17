class Solution {
    public int findPeakElement(int[] a) {
        int n = a.length;
        return peakEle(a);
    }

    public int peakEle(int[] b){
        int n = b.length; 
        int low = 1;
        int high = n-2;
        if(n==1){
            return 0;
        }else if(b[0] > b[1]){
            return 0;
        }else if(b[n-1] > b[n-2]){
            return (n-1);
        }
        while(low <= high){
            int mid = (low + high)/2;
            if(b[mid] > b[mid-1] && b[mid] > b[mid+1]){
                return mid;
            }

            if(b[mid] < b[mid+1]){
                low = mid+1;
            }
            else if(b[mid] > b[mid+1]) {
                high = mid;
            }
        }
        return low;
    }
}

// Concept: binary search
// Time complexity: O(logN)
// Space complexity: O(1)