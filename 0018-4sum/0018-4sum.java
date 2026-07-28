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
}


// Time Complexity: O(n^3)   *    O(logM)
//                 three for       hashmap
//                 loop          (M - variable)

// Space complexity: O(N) * O(no. of unique elements)*2  (N-number of elements)