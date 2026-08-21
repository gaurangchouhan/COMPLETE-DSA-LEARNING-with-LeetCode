class Solution {
    public int smallestDivisor(int[] a, int t) {
        int n = a.length;
        int min = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(max < a[i]){
                max = a[i];
            }
        }

        int ans = max;

        while(min <= max){
            int div = 0;
            int mid = min + (max - min)/2;

            for(int i=0; i<n; i++){
                div += (int) Math.ceil((double) a[i] /mid);
            }
            // System.out.println("div " + mid + ":"+ div); debugging

            if(div <= t){
                ans = Math.min(ans, mid);
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return ans;
    }
}

// Concept: Binary Search
// Time complexity: O(n)      *       O(logM)
//                 For loop         binary search 
//            inside while loop   (M: the maximum element in the array)

// Space complexity: O(1)