class Solution {
    public int missingInteger(int[] a) {
        int n = a.length;

        if(n==0){
            return 1;
        }
        if(n==1){
            return a[0] + 1;
        }

        int maxPreSum = Integer.MIN_VALUE;
        int preSum = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1] + 1) {
                preSum += a[i];
            } else {
                break;
            }
        }

        // System.out.println(maxPreSum);

        Set<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }

        int x = preSum;

        while (set.contains(x)) {
            x++;
        }
        return x;
    }
}