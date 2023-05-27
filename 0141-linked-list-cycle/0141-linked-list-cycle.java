/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(true){
            if(head!=null ){
                if(!set.contains(head)){
                    set.add(head);
                    head = head.next;    
                }else{
                    return true;
                }
                
            }else{
                return false;
            }
            
        }
    }
}