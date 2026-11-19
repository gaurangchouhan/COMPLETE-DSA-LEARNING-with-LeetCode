class Solution {
    public int minimizeSum(int[] a) {
        int n = a.length; 

        if(n<=3){
            return 0;
        }

        // Arrays.sort(a);

        // int change2smallest = a[n-1] - a[2];
        // int change1smallest1largest = a[n-2] - a[1];
        // int change2largest = a[n-3] - a[0];

        // return Math.min(change2smallest, Math.min(change1smallest1largest, change2largest));

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int thirdSmallest = Integer.MAX_VALUE;
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        // int found = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] < smallest) {
                thirdSmallest = secondSmallest;
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i] < secondSmallest) {
                thirdSmallest = secondSmallest;
                secondSmallest = a[i];
            } else if (a[i] < thirdSmallest) {
                thirdSmallest = a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = a[i];
            } else if (a[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = a[i];
            } else if (a[i] > thirdLargest) {
                thirdLargest = a[i];
            }
        }

        

        // System.out.println("smallest: " + smallest);
        // System.out.println("secondSmallest: " + secondSmallest);
        // System.out.println("thirdSmallest: " + thirdSmallest);
        // System.out.println("largest: " + largest);
        // System.out.println("secondLargest: " + secondLargest);
        // System.out.println("thirdLargest: " + thirdLargest);


        int change2smallest = largest - thirdSmallest;
        int change1smallest1largest = secondLargest - secondSmallest;
        int change2largest = thirdLargest - smallest;

        return Math.min(change2smallest, Math.min(change1smallest1largest, change2largest));
    }
}

// TC: O(2n)
// SC: O(1)