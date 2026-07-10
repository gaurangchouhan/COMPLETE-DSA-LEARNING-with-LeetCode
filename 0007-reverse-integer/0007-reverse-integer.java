class Solution {
    public int reverse(int x) {
        
        int newNum = 0;
        long rev = 0;
        while(x != 0){
            newNum = x%10;
            rev = rev*10 + newNum;
            x = x/10;
        }

        if(rev>Integer.MAX_VALUE||rev<Integer.MIN_VALUE){
            return 0;
        }else{
            return  (int)rev; 
        }        
    }
}