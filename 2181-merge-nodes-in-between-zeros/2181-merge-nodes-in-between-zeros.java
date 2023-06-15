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
    public ListNode mergeNodes(ListNode head) {
        ListNode root = new ListNode();
        ListNode node = root;
        int sum = 0;
        while(head.next!=null){
            sum += head.val;
            head = head.next;
            if(head.val==0){
                node.val = sum;
                if(head.next!=null){
                    node.next = new ListNode();
                    node = node.next;
                }
                sum = 0;
            }
        }
        return root;
    }
}