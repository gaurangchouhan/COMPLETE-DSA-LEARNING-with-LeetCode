class Solution {
    // 854/900 passed
    public int largestIntegerBetter(int[] a, int k) {
        int n = a.length;
        int cnt0 = 1;
        int cnt_n1 = 1;
        int ans = Integer.MIN_VALUE;
        // if(a[0] == a[n-1]){
        //     ans = -1;
        // }
        if(k>=2){
            if(k==n){
                int max = Integer.MIN_VALUE;
                for(int i=0; i<n; i++){
                    if(max < a[i]){
                        max = a[i];
                    }
                }
                ans = Math.max(ans, max);
            }
            else{
                for(int i=1; i<n-1; i++){
                    if(a[i]==a[0]){
                        cnt0 += 1;
                    }
                    else{
                        continue;
                    }
                }
                for(int i=1; i<n-1; i++){
                    if(a[i]==a[n-1]){
                        cnt_n1 += 1;
                    }
                    else{
                        continue;
                    }
                }
            }

            if(cnt0 == 1 && cnt_n1 == 1){
                ans = Math.max(ans, Math.max(a[0], a[n-1]));
            }else if(cnt0 == 1){
                ans = Math.max(ans, a[0]);
            }else if(cnt_n1 == 1){
                ans = Math.max(ans, a[n-1]);
            }else{
                ans = -1;
            }
        }
        else{
            if(a[0] == a[n-1]){
                ans = -1;
            }
            else{
                int max = Integer.MIN_VALUE;
                for(int i=0; i<n; i++){
                    if(max < a[i]){
                        max = a[i];
                    }
                }
                ans = Math.max(ans, max);
            }
        }

        return ans;
    }

    // Concept: for loop & if else
    // Time complexity: O(n)
    // Space complexity: O(1)


    public int largestInteger(int[] a, int k) {
        int n = a.length;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int ans = -1;

        if (k == n) {
            int max = Integer.MIN_VALUE;
            for (int x : a) {
                if (x > max) {
                    max = x;
                }
            }
            return max;
        }

        if (k == 1) {
            for (int x : a) {
                if (freq.get(x) == 1) { // frequency 1 get
                    if (x > ans) {
                        ans = x;
                    }
                }
            }
            return ans;
        }

        // 1 < k < n
        if (freq.get(a[0]) == 1) {
            ans = Math.max(ans, a[0]);
        }
        if (freq.get(a[n - 1]) == 1) {
            ans = Math.max(ans, a[n - 1]);
        }

        return ans;
    }

    // Concept: for loop & hashing
    // Time complexity: O(n)
    // Space complexity: O(n)
}