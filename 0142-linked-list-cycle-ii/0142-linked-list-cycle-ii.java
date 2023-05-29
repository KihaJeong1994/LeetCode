/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hair = head;
        ListNode tortoise = head;
        // phase 1 : check if there is cycle
        while(hair != null && hair.next != null){
            hair = hair.next.next;
            tortoise = tortoise.next;
            // phase 2 : if there is cycle
            if(hair == tortoise){
                // start tortoise from head & slow down hair
                tortoise = head;
                while(hair != tortoise){
                    hair = hair.next;
                    tortoise = tortoise.next;
                }
                return hair;
            }
        }
        return null;
    }
}