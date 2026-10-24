class Solution {

    public int dateToNumber(String date){
        int[] daysTillMonth = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        //System.out.println(month + " " + day);

        return daysTillMonth[month - 1] + day;
    }


    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        

        int dayNumAliceArrive = dateToNumber(arriveAlice);
        int dayNumBobArrive = dateToNumber(arriveBob);
        int dayNumAliceLeave = dateToNumber(leaveAlice);
        int dayNumBobLeave = dateToNumber(leaveBob);

        // if alice leaves before bob arrives || bob leaves before alice arrives then they do not meet
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