class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suffix = new int[m];
        Arrays.fill(suffix, -1);

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                suffix[j] = i;
                j--;
            }
            i--;
        }

        int[] answer = new int[m];
        int word2Index = 0;
        boolean changed = false;

        for (i = 0; i < n && word2Index < m; i++) {
            char current = word1.charAt(i);
            char required = word2.charAt(word2Index);

            // Exact match: always prefer the earliest index
            if (current == required) {
                answer[word2Index] = i;
                word2Index++;
            }
            /*
             * Use the one allowed modification if the remaining
             * part of word2 can still be matched after index i.
             */
            else if (!changed &&
                    (word2Index == m - 1 ||
                     (suffix[word2Index + 1] != -1 &&
                      i < suffix[word2Index + 1]))) {

                answer[word2Index] = i;
                word2Index++;
                changed = true;
            }
        }

        if (word2Index != m) {
            return new int[0];
        }

        return answer;
    }
}

// Time Complexity: O(m+n)
// Space complexity: O(m)