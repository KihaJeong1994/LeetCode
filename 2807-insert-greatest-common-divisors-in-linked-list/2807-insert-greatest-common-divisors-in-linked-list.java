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
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}