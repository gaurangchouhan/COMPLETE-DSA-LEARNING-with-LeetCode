class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int f = freq[25 - i];
            int presses = (i / 8) + 1;
            ans += f * presses;
        }

        return ans;
    }
}

// Time complexity: O(n) + O(nlogn) + O(26)
// Space Complexity: O(1)