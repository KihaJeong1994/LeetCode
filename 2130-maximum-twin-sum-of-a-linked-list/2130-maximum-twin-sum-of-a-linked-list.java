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
    public int pairSum(ListNode head) {
        int answer = 0;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast!=null){
            stack.push(head.val);
            head = head.next;
            fast = fast.next.next;
        }
        while (!stack.isEmpty()){
            answer = Math.max(stack.pop() + head.val, answer);
            head = head.next;
        }
        return answer;
    }
}