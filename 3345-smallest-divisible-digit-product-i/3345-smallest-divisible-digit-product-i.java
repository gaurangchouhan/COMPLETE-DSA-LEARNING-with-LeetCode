class Solution {
    public int smallestNumber(int n, int t) {
        int k = n;
        while (true) {
            int digitProd = digitProduct(k);
            if (digitProd % t == 0) {
                return k;
            }
            k++;
        }
    }

    public int digitProduct(int n){
        int product = 1;
        while(n>0){
            int digit = n % 10;
            product *= digit;
            n/=10;
        }
        return product;
    }
}

