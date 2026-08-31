/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        List<Integer> ls = new ArrayList<>();

        int pos = 1;

        while(curr != null && next != null && prev != null){
            
            // check if curr is a critical value
            if((curr.val > prev.val && curr.val > next.val) // maxima
                ||  
               (curr.val < prev.val && curr.val < next.val)) // minima
            {

                ls.add(pos);
            }


            // increament
            pos ++;
            prev = curr;
            curr = next;
            next = curr.next;
        }


        // find min and max dist
        if(!ls.isEmpty()){
            maxDist = ls.get(ls.size() - 1) - ls.get(0);
        }

        for(int i = 0; i < ls.size() - 1; i ++){
            int dist = (ls.get(i + 1) - ls.get(i));
        //System.out.println(minDist);
            minDist = (dist < minDist) ? dist : minDist;
        }


        //System.out.println(ls);

        if(minDist == Integer.MAX_VALUE || maxDist == 0) {
            minDist = -1;
            maxDist = -1;
        }
        return new int[]{minDist, maxDist};
    }
}