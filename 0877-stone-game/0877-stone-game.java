class Solution {
    // public boolean stoneGame(int[] piles) {
    //     return true;
    // }

    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }

        return find(0,0,dp,piles)>0?true:false;
    }
    static int find(int i,int j,int[][] dp,int[] piles){
        if(i==j){
            return piles[i];
        }

        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }

        int max=Integer.MIN_VALUE;

        int left=piles[i]+find(i+1,j,dp,piles);

        int right=piles[j]+find(i,j-1,dp,piles);

        max=Math.max(left,right);

        return dp[i][j]=max;
    }
}