class Solution {
    public int findGCD(int[] a) {
        int n = a.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(a[i]>max){
                max = a[i];
            }
            if(a[i]<min){
                min = a[i];
            }
        }

        return GCD(min, max);
    }

    private int GCD(int a, int b) {
        while (a>0 && b>0){
            if (a>b){
                a = a%b;
            }else {
                b = b%a;
            }
        }
        if (a==0){
            return b;
        }
        return a;
    }
}