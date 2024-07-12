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
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode nodeToStack = head;
        while(nodeToStack!=null){
            stack.offer(nodeToStack);
            nodeToStack = nodeToStack.next;
        }
        ListNode node = head;
        ListNode nextNode = stack.pollLast();
        while(node.next!=nextNode && node!=nextNode){
            ListNode tmp = node.next;
            nextNode.next = node.next;
            node.next = nextNode;
            node = tmp;
            nextNode = stack.pollLast();
        }
        if(node.next==nextNode){
            node.next = nextNode;
            nextNode.next = null;
        }else{
            node.next = null;
        }
    }
}