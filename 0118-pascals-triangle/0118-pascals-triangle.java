class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> main = new ArrayList<>();

        for (int j = 0; j < numRows; j++) {
            List<Integer> list = new ArrayList<>();

            long ans = 1;
            list.add((int) ans);

            for (int i = 1; i <= j; i++) {
                ans = ans * (j - i + 1) / i;
                list.add((int) ans);
            }

            main.add(list);
        }

        return main;
    }
}

// Time complexity: O(numRows*numRows)
// Space complexity: O(numRows^2)