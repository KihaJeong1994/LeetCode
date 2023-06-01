/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = 1;
        int n = 1;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA.next != null){
            nodeA = nodeA.next;
            m++;
        }
        while(nodeB.next != null){
            nodeB = nodeB.next;
            n++;
        }
        if(nodeA!=nodeB){
            return null;
        }
        int diff = 0;
        ListNode nodeC = null;
        ListNode nodeD = null;
        if(m-n>0){
            diff = m-n;
            nodeC = headA;
            nodeD = headB;
        }else{
            diff = n-m;
            nodeC = headB;
            nodeD = headA;
            
        }
        for(int i=0;i<diff;i++){
            nodeC = nodeC.next;
        }
        while(true){
            if(nodeD==nodeC){
                return nodeD;
            }
            nodeD = nodeD.next;
            nodeC = nodeC.next;
        }
        
    }
}