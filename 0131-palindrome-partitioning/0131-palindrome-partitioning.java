class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ll = new ArrayList<>();
        List<String> l = new ArrayList<>();
        return checkFn(s, 0, l, ll);
    }

    public List<List<String>> checkFn(String s,  int idx, List<String> l, List<List<String>> ll){

        if(idx == s.length()){
            ll.add(new ArrayList<>(l));
            return ll;
        }

        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                l.add(s.substring(idx, i+1));
                checkFn(s, i+1, l, ll);
                l.remove(l.size() - 1);
            }
        }
        return ll;
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
 
// Time complexity: O(N × 2^N)
// Space complexity: O(N × 2^N)