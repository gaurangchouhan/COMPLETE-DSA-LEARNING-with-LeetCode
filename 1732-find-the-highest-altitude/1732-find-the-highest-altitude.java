import java.util.Scanner;

class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0, j=0;
        for (int i = 0; i < gain.length; i++) {
            int k = j+gain[i];
            if (k>max){
                max=k;
            }
            j=k;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] gain = new int[size];
        for (int i = 0; i < size; i++) {
            gain[i] = sc.nextInt();
        }

        Solution s = new Solution();
        int max = s.largestAltitude(gain);
        System.out.println(max);
    }
}