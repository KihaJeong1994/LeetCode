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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowNode = head;
        ListNode fastNode = getFastNode(head,n);
        if(fastNode==null){
            head = head.next;
            return head;
        }
        while(fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }

    private ListNode getFastNode(ListNode node, int n) {
        while(n!=0){
            node = node.next;
            n--;
        }
        return node;
    }

}