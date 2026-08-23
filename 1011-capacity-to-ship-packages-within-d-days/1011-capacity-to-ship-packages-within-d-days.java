class Solution {
    public int shipWithinDays(int[] w, int days) {
        int n = w.length;
        int maxCap = 0;
        int minCap = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            maxCap += w[i];
            if(minCap < w[i]){
                minCap = w[i];
            }
        }

        int ans = 0; 

        while(minCap <= maxCap){
            int mid = (minCap + maxCap)/2;

            int checkDays = Days(w, mid);

            if(checkDays <= days){
                ans = mid;
                maxCap = mid - 1;
            }else{
                minCap = mid + 1;
            }
        }
        return ans;
    }

    public int Days(int[] w, int cap){
        int day = 1;
        int load = 0;
        for(int i=0; i < w.length; i++){
            if(load + w[i] > cap){
                day += 1;
                load = w[i];
            }else{
                load += w[i];
            }
        }
        return day;
    }
}

// Concept: binary search 
// Time complexity:      O(logN)     *     O(N) 
//                    Binary search       for loop

// Space complexity: O(1)