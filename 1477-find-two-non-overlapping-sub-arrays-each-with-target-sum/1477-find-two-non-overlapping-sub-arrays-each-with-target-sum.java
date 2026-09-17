class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLenTillIdx = new int[n];
        int i=0, j=0;
        int currSum = 0;
        int result = Integer.MAX_VALUE;
        int bestMin = Integer.MAX_VALUE;
        while(j<n){
            currSum += arr[j];
            while(currSum > target){
                currSum -= arr[i];
                i++;
            }

            if(currSum == target){
                int len = j-i+1;

                if(i>0 && minLenTillIdx[i-1] != Integer.MAX_VALUE){
                    result = Math.min(result, len + minLenTillIdx[i-1]);
                }

                bestMin = Math.min(bestMin, len);
            }
            minLenTillIdx[j] = bestMin;
            j++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}

// Concept: sliding window 
// Time complexity: O(n^2)
// Space complexity: O(n)