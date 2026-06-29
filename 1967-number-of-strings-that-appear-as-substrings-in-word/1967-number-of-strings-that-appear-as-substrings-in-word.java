class Solution {
    public int numOfStrings(String[] p, String word) {
        int n = p.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (word.contains(p[i])){
                count++;
            }
        }
        return count;
    }
}  