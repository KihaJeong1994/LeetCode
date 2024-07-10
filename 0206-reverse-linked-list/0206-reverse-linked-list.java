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
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while(node!=null){
            stack.offer(new ListNode(node.val));
            node = node.next;
        }
        ListNode poppedNodeHead = stack.peekLast();
        ListNode poppedNode = stack.pollLast();
        while(poppedNode!=null){
            ListNode poppedNodeNext = stack.pollLast();
            poppedNode.next = poppedNodeNext;
            poppedNode = poppedNodeNext;
        }
        return poppedNodeHead;
    }
}