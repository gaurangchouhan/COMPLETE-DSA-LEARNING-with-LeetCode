class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();

        HashMap<Character, Integer> hm = new HashMap<>();
        
        int MaxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int len = 0;
            for (int j = i; j < n; j++) {
                if (!(hm.containsKey(s.charAt(j)))){
                    hm.put(s.charAt(j), 1);
                    len++;
                } else if (hm.containsKey(s.charAt(j)) && hm.get(s.charAt(j))<2) {
                    hm.replace(s.charAt(j), hm.get(s.charAt(j))+1);
                    len++;
                } else{
                    break;
                }
            }
            MaxLen = Math.max(MaxLen, len);
            hm.clear();
        }
        return MaxLen;
    }
}

// Concept: hashmap & for loop
// Time complexity: O(n^2)
// Space complexity: O(n)