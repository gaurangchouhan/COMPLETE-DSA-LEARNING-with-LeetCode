class Solution {
    public int longestValidParentheses(String s) {
        // char one = '(';
        // char two = ')';

        // char[] ch = s.toCharArray();
        // int cnt = 0;

        // int l = 0;
        // int r = ch.length-1;
        // while (l<r) {
        //     if (ch[l]==one && ch[r] == two) {
        //         cnt+=2;
        //         l++;
        //         r--;
        //     } 
        //     else if (ch[l] == one && ch[r] == one) {
        //         r--;
        //     } else if (ch[l] == two && ch[r] == two) {
        //         l++;
        //     }else {
        //         l++;
        //         r--;
        //     }
        // }
        // return cnt;

        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
        stack.push(-1);
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}