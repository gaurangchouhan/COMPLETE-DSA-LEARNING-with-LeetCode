class Solution {
    public boolean isAnagramBrute(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m) return false;
        Map<Character, Integer> mpS = new HashMap<>();
        Map<Character, Integer> mpT = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (mpS.containsKey(s.charAt(i))){
                mpS.replace(s.charAt(i), mpS.get(s.charAt(i))+1);
            }else {
                mpS.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < m; i++) {
            if (mpT.containsKey(t.charAt(i))){
                mpT.replace(t.charAt(i), mpT.get(t.charAt(i))+1);
            }else {
                mpT.put(t.charAt(i), 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if ((!mpS.containsKey(s.charAt(i))) && mpT.containsKey(s.charAt(i))){
                return false;
            } else if (mpS.containsKey(s.charAt(i)) && (!mpT.containsKey(s.charAt(i)))) {
                return false;
            }else {
                if (mpS.get(s.charAt(i)).equals(mpT.get(s.charAt(i)))){
                    continue;
                }else {
                    return false;
                }
            }
        }
//        boolean check = false;
//        for (int i = 0; i < n; i++) {
//            char c = t.charAt(i);
//            String str = "" + c;
//            if (s.contains(str)){
//                check = true;
//            }else {
//                return false;
//            }
//        }
        return true;
    }

    // Time complexity: O(3n)
    // Space complexity : O(2n)

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }

    // Time complexity: O(2n)
    // Space complexity : O(n)
}

