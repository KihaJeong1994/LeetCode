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
        if(head == null) return null;
        ListNode node = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while(node!=null){
            stack.offer(node.val);
            node = node.next;
        }
        ListNode poppedNodeHead = new ListNode(stack.pollLast());
        ListNode node2 = poppedNodeHead;
        while(!stack.isEmpty()){
            ListNode poppedNodeNext = new ListNode(stack.pollLast());
            node2.next = poppedNodeNext;
            node2 = poppedNodeNext;
        }
        return poppedNodeHead;
    }
}