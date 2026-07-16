class Solution {
    public long gcdSum(int[] a) {
        int n = a.length;
        int maximum = Integer.MIN_VALUE;

        int[] mx = new int[n];
        int[] prefixGcd = new int[n];

        for (int i = 0; i < n; i++) {
            maximum = Math.max(a[i],maximum);
            mx[i] = maximum;
            prefixGcd[i] = GCD(a[i], mx[i]);
        }

        Arrays.sort(prefixGcd);  // O(nlogn)
        long sum = 0;

        int k = n-1;
        for (int i = 0; i < n/2; i++) {      // O((n/2)logM)
            if (i == k){
                break;
            }else {
                sum += GCD(prefixGcd[i], prefixGcd[k]);
                k--;
            }
        }
        return sum;
    }

    // Euclidean method of GCD (O((n)log(maximum value in the array(M))))
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

// Time Complexity: O(nlogM)+O(nlogn)+O((n/2)logM)) = O(nlogn+nlogM)
// Space Complexity: O(n)  +    O(n)     =    O(2n)
//                  mx[n]   prefixGcd[n]