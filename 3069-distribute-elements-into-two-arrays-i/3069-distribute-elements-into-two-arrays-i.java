class Solution {
    public int[] resultArray(int[] a) {
        int n = a.length;
        int[] result = new int[n];

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(a[0]);
        l2.add(a[1]);
        
        for (int i = 2; i < n; i++) {
            if (l1.getLast() > l2.getLast()){
                l1.add(a[i]);
            }else {
                l2.add(a[i]);
            }
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i<l1.size()){
                result[i] = l1.get(i);
            }else if(j<l2.size()) {
                result[i] = l2.get(j);
                j++;
            }
        }
        return result;
    }
}

// Concept: List, for loop
// Time complexity:     O(n)         +         O(n) = 2*O(n)
//                   for loop 1             for loop 2

// Space complexity: O(no. of ele in l1) + O(no. of ele in l2) + O(result.length) 