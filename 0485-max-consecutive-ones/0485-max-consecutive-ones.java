class Solution {
    public int findMaxConsecutiveOnes(int[] a) {
        ArrayList<Integer> one = new ArrayList<>();
        int count = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i]!=0){
                count++;
            }else{
                one.add(count);
                count=0;
            }
        }
        one.add(count);
        int max = 0;
        for (int i = 0; i < one.size(); i++) {
            if (max<one.get(i)){
                max = one.get(i);
            }
        }
        return max;
    }
}