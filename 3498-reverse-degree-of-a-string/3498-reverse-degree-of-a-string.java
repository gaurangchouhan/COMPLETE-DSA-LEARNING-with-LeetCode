class Solution {
    public int reverseDegree(String s) {
        int n = s.length();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int serialNum = s.charAt(i) - 'a';
            int reverseSerialNum = 26 - serialNum;
            
            sum += (reverseSerialNum*(i+1));
        }

        return sum;
    }
}

// Concept: string 
// Time complexity: O(n)
// Space complexity: O(1)