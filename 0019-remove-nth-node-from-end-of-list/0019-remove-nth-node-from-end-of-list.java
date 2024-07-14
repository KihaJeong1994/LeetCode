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
        ListNode node = head;
        int len = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while(node!=null){
            map.put(len,node);
            node = node.next;
            len++;
        }
        map.put(len,null);
        if(len == n){
            head = head.next;
        }else{
            map.get(len-n-1).next = map.get(len-n+1);
        }
        return head;
    }
}