class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        int n = strs.length;

        if(n==0) return "";
        if(n==1) return strs[0];

        Arrays.sort(strs);
        
        String first = strs[0];
        String last = strs[n-1];

        for(int i=0; i < Math.min(first.length(), last.length()); i++){
            if(first.charAt(i) != last.charAt(i)){
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}

// Concept: String
// Time complexity: O(n)
// Space complexity: O(n)