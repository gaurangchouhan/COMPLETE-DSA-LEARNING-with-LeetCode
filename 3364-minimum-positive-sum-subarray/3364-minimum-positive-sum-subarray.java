class Solution {
    public int minimumSumSubarrayMYSOLn(List<Integer> list, int l, int r) {
        int n = list.size();

        int sum = 0;
        int ans = Integer.MAX_VALUE;

        if(l == 1 && r == 1){
            for(int i = 0; i<n; i++){
                if(list.get(i) > 0){
                    ans = Math.min(ans, list.get(i));
                }
            }
            return ans<0 || ans == Integer.MAX_VALUE ? -1 : ans;
        }

        for(int i=0; i<n; i++){
            if(l>1 && r>1){
                int start = list.get(i);
                sum += start;
            }

            for(int j=i; j<n; j++){
                if(j-i+1 >= l && j-r+1 <= r){
                    sum += list.get(j);
                    if(sum > 0){
                        ans = Math.min(ans, sum);
                    }
                    System.out.println(ans);
                }
                else{
                    continue;
                }
            }
            sum = 0;
        }

        return ans<0 || ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int minimumSumSubarray(List<Integer> list, int l, int r) {
        int n = list.size();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += list.get(j);

                int length = j - i + 1;

                if (length > r) {
                    break;
                }

                if (length >= l && sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

// TC: O(n^2)
// SC: O(1)