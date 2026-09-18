class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // Check s -> t mapping
            if (sToT.containsKey(cs)) {
                if (sToT.get(cs) != ct) {
                    return false;
                }
            } else {
                sToT.put(cs, ct);
            }

            // Check t -> s mapping
            if (tToS.containsKey(ct)) {
                if (tToS.get(ct) != cs) {
                    return false;
                }
            } else {
                tToS.put(ct, cs);
            }
        }

        return true;
    }

// Concept: string
// Time complexity: O(n)
// Space complexity: O(2n)

    public boolean isIsomorphicOptimal(String s, String t) {
        HashMap<Character, Integer> charIndexS = new HashMap<>();
        HashMap<Character, Integer> charIndexT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!charIndexS.containsKey(s.charAt(i))) {
                charIndexS.put(s.charAt(i), i);
            }

            if (!charIndexT.containsKey(t.charAt(i))) {
                charIndexT.put(t.charAt(i), i);
            }

            if (!charIndexS.get(s.charAt(i)).equals(charIndexT.get(t.charAt(i)))) {
                return false;
            }
        }

        return true;        
    }

// Concept: string
// Time complexity: O(n)
// Space complexity: O(2n)
    

// 40/48 test cases passed
    public boolean MyLogic(String s, String t) {
        int n = s.length();
        Map<Character, Character> hm = new HashMap<>();
        if(n==1)return true;
        for (int i = 0; i < n; i++) {
            


            if (hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }
            else {
                hm.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

// Concept: string
// Time complexity: O(n)
// Space complexity: O(n)
}
