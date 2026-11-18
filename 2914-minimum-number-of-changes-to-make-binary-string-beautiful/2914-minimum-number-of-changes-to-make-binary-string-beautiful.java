class Solution {
    public int minChanges(String s) {
        int n = s.length();

        // int changesLR = 0;
        // for(int i=0; i<n/2; i++){
        //     if(s.charAt(i) != s.charAt((n/2)+i)){
        //         changesLR++;
        //     }
        // }

        // int changesRL = 0;
        // for(int i=n-1; i>n/2-1; i--){
        //     if(s.charAt(i) != s.charAt(i-(n/2))){
        //         changesRL++;
        //     }
        // }

        // System.out.println(changesLR);
        // System.out.println(changesRL);

        int changes = 0;
        for(int i=1; i<n; i+=2){
            if(s.charAt(i) != s.charAt(i-1)){
                changes++;
            }
        }

        // return Math.min(changesRL, changesLR);
        return changes;
    }
}

// TC: O(n)
// SC: O(1)