class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        int n = num.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) { // near abt O(n)
            Set<Integer> hashset = new HashSet<>();

            for (int j = i + 1; j < n; j++) {  // near abt O(n)
                int third = -(num[i] + num[j]);

                if (hashset.contains(third)) { // near abt O(logM) 
                    List<Integer> temp = Arrays.asList(num[i], num[j], third);
                    Collections.sort(temp);
                    st.add(new ArrayList<>(temp));
                }

                hashset.add(num[j]);
            }
        }

        return new ArrayList<>(st);
    }
}

// Time Complexity: O(n^2)   *    O(logM)
//                 two for        hashmap
//                 loop          (M - variable)

// Space complexity: O(N) * O(no. of unique elements)*2  (N-number of elements)