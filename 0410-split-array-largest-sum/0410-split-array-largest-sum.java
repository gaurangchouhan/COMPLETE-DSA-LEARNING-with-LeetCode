class Solution {
    public int splitArray(int[] a, int k) {
        int low = Arrays.stream(a).max().getAsInt(); 
        int high = Arrays.stream(a).sum(); 

        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(a, mid);

            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }
        return low;
    }

    public int countPartitions(int[] a, int maxSum) {
        int partitions = 1; 
        long subarraySum = 0; 

        for (int num : a) {
            if (subarraySum + num <= maxSum) {
                subarraySum += num;
            } else {
                partitions++;
                subarraySum = num;
            }
        }
        return partitions;
    }
}