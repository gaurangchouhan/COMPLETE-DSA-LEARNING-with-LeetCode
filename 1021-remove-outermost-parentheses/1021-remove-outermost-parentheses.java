class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        int cnt = 0;
        int i=0;
        for(int j=0; j<n; j++){
            if(s.charAt(j) == '('){
                cnt++; 
            }else{
                cnt--;
            }

            if(cnt == 0){
                ans.append(complete(s, i, j));
                i = j+1;
            }
        }
        return ans.toString();
    }

    public String complete(String s, int i, int j) {
        StringBuilder partialAns = new StringBuilder();
        for (int k = i + 1; k <= j - 1; k++) {
            partialAns.append(s.charAt(k));
        }
        return partialAns.toString();     
    }  

    public String removeOuterParenthesesOptimalApproach (String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) ans.append(ch);
                depth++;
            } 
            else {
                depth--;
                if (depth > 0) ans.append(ch);
            }
        }

        return ans.toString();
    }
}

// Concept: string 
// Time complexity: O(n^2)
// Space complexity: O(2n)