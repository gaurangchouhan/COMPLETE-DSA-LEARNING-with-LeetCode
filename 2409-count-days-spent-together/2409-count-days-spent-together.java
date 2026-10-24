class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int AliceArriveMonth = 0;
        int AliceArriveDate = 0;
        int AliceLeaveMonth = 0;
        int AliceLeaveDate = 0;

        int BobArriveMonth = 0;
        int BobArriveDate = 0;
        int BobLeaveMonth = 0;
        int BobLeaveDate = 0;

        int i = 0;
        while(i < 2){

            AliceArriveMonth = (AliceArriveMonth*10) + (arriveAlice.charAt(i) - '0');

            AliceLeaveMonth = (AliceLeaveMonth*10) + (leaveAlice.charAt(i) - '0');

            BobArriveMonth = (BobArriveMonth*10) + (arriveBob.charAt(i) - '0');

            BobLeaveMonth = (BobLeaveMonth*10) + (leaveBob.charAt(i) - '0');

            i++;
        }

        int j = 3;
        while(j<5){

            AliceArriveDate = (AliceArriveDate*10) + (arriveAlice.charAt(j) - '0');

            AliceLeaveDate = (AliceLeaveDate*10) + (leaveAlice.charAt(j) - '0');

            BobArriveDate = (BobArriveDate*10) + (arriveBob.charAt(j) - '0');

            BobLeaveDate = (BobLeaveDate*10) + (leaveBob.charAt(j) - '0');

            j++;
        }

        int aliceStart = dayOfYear(AliceArriveMonth, AliceArriveDate);
        int aliceEnd = dayOfYear(AliceLeaveMonth, AliceLeaveDate);

        int bobStart = dayOfYear(BobArriveMonth, BobArriveDate);
        int bobEnd = dayOfYear(BobLeaveMonth, BobLeaveDate);

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        return Math.max(0, end - start + 1);
    }

    private int dayOfYear(int month, int day) {
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int total = day;

        for (int i = 0; i < month - 1; i++) {
            total += daysInMonth[i];
        }

        return total;
    }
}

// Time complexity: O(1)
// Space complexity: O(1)