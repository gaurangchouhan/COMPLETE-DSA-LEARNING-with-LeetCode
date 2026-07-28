class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            while (freq[i] >= 2) {
                left.append((char) (i + 'a'));
                right.insert(0, (char) (i + 'a'));
                freq[i] -= 2;
            }

            if (freq[i] == 1) {
                middle = (char) (i + 'a');
            }
        }

        if (middle != 0) {
            return left.toString() + middle + right.toString();
        }
        
        return left.toString() + right.toString();
    }
}