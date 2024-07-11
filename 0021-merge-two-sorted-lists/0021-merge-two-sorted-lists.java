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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode answerHead;
        ListNode anotherHead;
        if(list1.val < list2.val){
            answerHead = list1;
            anotherHead = list2;
        }else{
            answerHead = list2;
            anotherHead = list1;
        }
        ListNode answerNode = answerHead;
        ListNode anotherNode = anotherHead;
        while(answerNode.next !=null && anotherNode != null){
            if(answerNode.next.val < anotherNode.val){
                answerNode = answerNode.next;
            }else{
                ListNode anotherNodeTmp = anotherNode.next;
                anotherNode.next = answerNode.next;
                answerNode.next = anotherNode;
                answerNode = answerNode.next;
                anotherNode = anotherNodeTmp;
            }
        }
        if(answerNode.next == null){
            answerNode.next = anotherNode;
        }

        return answerHead;
    }

}