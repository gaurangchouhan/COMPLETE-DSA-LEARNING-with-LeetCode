class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;

        for(int num:arr){
            if(num<=k){
                k++;
                // System.out.println("num = " + num);
                // System.out.println("k = " + k);
            }else{
                break;
            }
        }
        return k;
    }
}

// Concept: Linear Search
// Time Complexity: O(n)
// Space Complexity: O(1)