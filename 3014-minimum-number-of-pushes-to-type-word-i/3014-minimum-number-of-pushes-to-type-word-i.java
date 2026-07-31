class Solution {
    HashMap<Integer, List<Character>> map = new HashMap<>();
    public int minimumPushes(String word) {
        Set<Character> set = new HashSet<>();
        int pushes = 1;
        int pushesCount = 0;
        int setSize = 0;
        for(char ch : word.toCharArray()){
            if(setSize == 8){
                setSize = 0;
                pushes++;  
            } 

            set.add(ch);
            setSize++;
            pushesCount += pushes;   
        }

        return pushesCount;
    }
    // Time complexity: O(n) because of one for loop
    // Space complexity: O(n) because of set data structure 

    public int minimumPushesOptimalSolution(String word) {
        int n = word.length();
        int fullGroups = n / 8;
        int remainder = n % 8;

        int ans = 0;
        for (int k = 1; k <= fullGroups; k++) {
            ans += 8 * k;
        }
        ans += remainder * (fullGroups + 1);

        return ans;
    }
}

// Time complexity: O(n) because of one for loop
// Space complexity: O(1)  