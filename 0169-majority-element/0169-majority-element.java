class Solution {
    //Better Solution
    // public int majorityElement(int[] nums) {
        // int n = nums.length;
        // HashMap<Integer,Integer> hm = new HashMap<>();
        
        // int max = 0, ans = 0;
        // for(int i=0; i<n; i++){
        //     int key = nums[i];
        //     int freq = 0;
        //     if(hm.containsKey(key)){
        //         freq = hm.get(key);
        //         hm.replace(nums[i], freq++);
        //     }
        //         hm.put(nums[i], freq++);

        //     if (freq>max){
        //         max=freq;
        //         ans = key;
        //     }
        // }
        // return ans;
    // }

    // Optimall Solution
    public int majorityElement(int[] a) {
        int n = a.length;
        int cnt = 0;
        int ele = 0;

        for(int i=0; i<n; i++){
            if(cnt==0){
                cnt =1;
                ele = a[i];
            }
            else if(a[i] == ele) {
                cnt++;
            }
            else {
                cnt--;
            }
        }

        int cnt1 = 0;
        for(int i=0; i<n; i++){
            if (a[i] == ele) cnt1++;
        }
        if (cnt1 > (n/ 2)) {
            return ele;
        }
        return 0;
    }
}