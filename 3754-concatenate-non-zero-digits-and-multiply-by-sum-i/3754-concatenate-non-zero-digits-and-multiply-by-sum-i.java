class Solution {
    // Better Solution
    public long sumAndMultiply(int n) {
        long x = 0;
        long digit = 0;
        long sum = 0;
        List<Integer> l = new ArrayList<>();
        while (n>0){
            int newNum = n%10;
            if (newNum != 0){
                sum+=newNum;
                l.add(newNum);
                digit += 1;
            }
            n = n/10;
        }

        if (sum == 1){
            return 1;
        }

        if (sum == 0){
            return 0;
        }
        
        if (digit == 1){
            return l.getFirst()*l.getFirst();
        }

        long k = l.getLast()*10;
        for (int i =  l.size()-1; i >= 0; i--) {
            if (i == l.size()-1){
                x = k+l.get(i);
            }else {
            x = k+l.get(i);
            k = x * 10;
            }
        }
        return x*sum;
    }

    // Optimal Solution

    // public long sumAndMultiply(int n) {
    //     int x=0;
    //     int sum=0;
    //     int i=1;
    //     while(n>0){
    //         int m=n % 10;
    //         n /=10;
    //         if(m == 0){
    //             continue;
    //         }
    //         sum += m;
    //         x += (m * i);
    //         i *=10;
    //     }
    //     return (long) x * sum;
    // }
}