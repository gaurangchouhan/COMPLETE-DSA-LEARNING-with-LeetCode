class Solution {
    public int minInsertions(String s) {
        int res = 0, need = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                need += 2;

                // Complete the previous closing pair if needed.
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            } else {
                need--;

                // Insert an opening parenthesis for this ')'.
                if (need < 0) {
                    res++;
                    need = 1;
                }
            }
        }

        // Insert all remaining required closing parentheses.
        return res + need;
    }
}

// Approach : greedy 
// Time Complexity: O(n)
// Space Complexity: O(1)