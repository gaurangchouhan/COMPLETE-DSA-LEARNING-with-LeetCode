class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        int n = num.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) { // near abt O(n)
            for (int j = i + 1; j < n; j++) {  // near abt O(n)
                Set<Integer> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long fourth = (long) target - (long) num[i] - num[j] - num[k];

                    if (fourth >= Integer.MIN_VALUE && fourth <= Integer.MAX_VALUE
                            && hashset.contains((int) fourth)) {
                        List<Integer> temp = Arrays.asList(num[i], num[j], num[k], (int) fourth);
                        Collections.sort(temp);
                        st.add(new ArrayList<>(temp)); 
                    }
                
                hashset.add(num[k]);
                }
            }
        }
        return new ArrayList<>(st);
    }

    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {

                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = 0;
                    sum += nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target) {

                        ans.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[k],
                                nums[l]
                        ));

                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }

                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }
}


// Time Complexity: O(n^3)   *    O(logM)
//                 three for       hashmap
//                 loop          (M - variable)

// Space complexity: O(N) * O(no. of unique elements)*2  (N-number of elements)