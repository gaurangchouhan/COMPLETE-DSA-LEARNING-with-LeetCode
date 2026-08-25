class Solution {
    public int missingMultiple(int[] a, int k) {

        // Approach 1
        // int n = a.length;
        // if(n == 1 && a[0] == k){
        //     return 2*k;
        // }
        // else if(n==100 && k==1){
        //     return a[n-1]+1;
        // }
        // List<Integer> l = new ArrayList<>();
        // for(int i=0; i<n; i++){
        //     l.add(a[i]);
        // }

        // int ans = 0;
        // for(int i=1; i<101; i++){
        //     int table = k*i;
        //     if(l.contains(table)){
        //         continue;
        //     }else{
        //         ans = table;
        //         break;
        //     }
        // }
        // return ans;

        // Time complexity: O(n)
        // Space Complexity: O(n)

        List<Integer> l = new ArrayList<>();
        for(int i =0;i<a.length;i++){
            if(a[i]%k==0){
                l.add(a[i]);
            }
        }
        for(int j=1;j<=l.size()+1;j++){
            if(!l.contains(k*j)){
                return k*j;
            }
        }
        return 0;

        // Time complexity: O(n)
        // Space Complexity: O(n)
    }
}