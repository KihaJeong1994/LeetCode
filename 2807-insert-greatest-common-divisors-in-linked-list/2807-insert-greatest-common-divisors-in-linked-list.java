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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode now = head;
        ListNode child = null;
        while(now.next!=null){
            child = now.next;
            int val = greatestCommonDivisor(now.val, child.val);
            ListNode divNode = new ListNode(val,child);
            now.next = divNode;
            now = child;
        }
        return head;
    }
    
    private int greatestCommonDivisor(int a, int b){
        int divisor = 1;
        int min = Math.min(a,b);
        for(int i=2; i<=min; i++){
            if(a%i==0 && b%i==0){
                divisor = i;
            }
        }
        return divisor;
    }
}