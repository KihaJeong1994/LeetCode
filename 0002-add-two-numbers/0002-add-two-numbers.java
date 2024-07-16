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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // add l1 and l2, and change each node's value to its sum
        // I can use longer one for answer
        ListNode l1Node = l1;
        ListNode l2Node = l2;
        ListNode answerNode = l1;
        while(l1Node != null || l2Node != null){

            if(l1Node != null && l2Node != null){
                int sum = l1Node.val + l2Node.val;
                l1Node.val = sum%10;
                l2Node.val = sum%10;
                if(sum>=10){
                    if(l1Node.next != null){
                        l1Node.next.val++;
                    }else if(l2Node.next != null){
                        l2Node.next.val++;
                    }else{
                        l1Node.next = new ListNode(1);
                        return l1;
                    }
                }
                l1Node = l1Node.next;
                l2Node = l2Node.next;
            }else if(l1Node != null){ // if l2Node is null
                int sum = l1Node.val;
                l1Node.val = sum%10;
                if(sum>=10){
                    if(l1Node.next != null){
                        l1Node.next.val++;
                    }else{
                        l1Node.next = new ListNode(1);
                        return l1;
                    }
                }
                l1Node = l1Node.next;
            }else{ // if l1Node is null
                answerNode = l2;
                int sum = l2Node.val;
                l2Node.val = sum%10;
                if(sum>=10){
                    if(l2Node.next != null){
                        l2Node.next.val++;
                    }else{
                        l2Node.next = new ListNode(1);
                        return l2;
                    }
                }
                l2Node = l2Node.next;
            }
            
        }
        return answerNode;

    }
}