class Solution {
    int[] daysTillMonth;


    public int dateToNumber(String date){
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        //System.out.println(month + " " + day);

        return daysTillMonth[month - 1] + day;
    }


    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysTillMonth = new int[12];

        for(int i = 1; i < 12; i ++){
            daysTillMonth[i] = daysTillMonth[i - 1] + daysInMonth[i-1];
        }

        int dayNumAliceArrive = dateToNumber(arriveAlice);
        int dayNumBobArrive = dateToNumber(arriveBob);
        int dayNumAliceLeave = dateToNumber(leaveAlice);
        int dayNumBobLeave = dateToNumber(leaveBob);

        // if alice leaves before bob arrives || bob leaves before alice arrives 
        if(dayNumAliceLeave < dayNumBobArrive ||
            dayNumBobLeave < dayNumAliceArrive){
                return 0;
            }


//System.out.println(dayNumAliceArrive + " " + dayNumBobArrive + " " + dayNumAliceLeave + " " + dayNumBobLeave);


        return Math.abs(
            Math.max(dayNumBobArrive, dayNumAliceArrive)
            - Math.min(dayNumAliceLeave, dayNumBobLeave)
        ) + 1;


        //return dateToNumber(arriveAlice);
    }
}