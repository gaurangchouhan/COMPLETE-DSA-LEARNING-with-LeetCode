class Solution {
    //Wrong Thinking
    // public int lengthOfLongestSubstring(String s) {
    //    int n = s.length();
    //     List<String> l = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         if (!(l.contains(String.valueOf(s.charAt(i))))){
    //             l.add(String.valueOf(s.charAt(i)));
    //         }
    //     }
    //     return l.size();
    // }


    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int i = 0;
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {

            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}