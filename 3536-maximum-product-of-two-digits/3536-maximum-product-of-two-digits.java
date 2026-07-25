import java.util.Vector;

class Solution {
    public int maxProduct(int a) {
        int maxProduct = 0;
        Vector<Integer> v = new Vector<>();

        while(a>0){
            int singleDigit = a%10;
            v.add(singleDigit);
            a /= 10;
        }

        if(v.size()==1){
            return v.getFirst();
        }

        int n = v.size();

        for(int i = 0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int product = v.get(i) * v.get(j);
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }
}

// Time Complexity: O(n) + O(n^2)
//                  while  two for
//                  loop    loop

// Space Complexity: O(n) because of vector 