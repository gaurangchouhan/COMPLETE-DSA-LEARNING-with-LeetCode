class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        // int completeBracket = 0;
        Stack<Character> stack = new Stack<>();
        int open = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                open++;
            }
        }

        return open + stack.size();
    }
}

//T.C : O(n)
//S.C : O(n)