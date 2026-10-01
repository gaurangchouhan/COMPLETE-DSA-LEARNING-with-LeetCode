class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n==1) return false;

        Stack<Character> st = new Stack<>();
        st.empty();
        boolean edgeCase = false;
        int i=0;
        while(i<n){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                st.push(s.charAt(i));
                if(edgeCase == true){
                    edgeCase = false;
                }
            }
            else if(!st.empty()){
                char ch = s.charAt(i);
                edgeCase = true;
                if(ch == '}'){
                    if(st.peek()=='{'){
                        st.pop();
                    }else {
                        return false;
                    }
                }
                else if(ch == ']'){
                    if(st.peek()=='['){
                        st.pop();
                    }else {
                        return false;
                    }
                }else {
                    if(st.peek()=='('){
                        st.pop();
                    }else {
                        return false;
                    }
                }
            }
            else{
                return false;
            }
            i++;
        }

        if(edgeCase == false || !st.empty()){
            return false;
        }
        
        return true;
    }
}

// TC: O(n)
// SC: O(1)