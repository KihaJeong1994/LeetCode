/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // what if I store the exact memory address of original and copy?
        Map<Node,Node> nodeMap = new HashMap<>();
        Node node = head;
        while(node!=null){
            nodeMap.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while(node!=null){
            nodeMap.get(node).next = nodeMap.get(node.next);
            nodeMap.get(node).random =nodeMap.get(node.random);
            node = node.next;
        }
        return nodeMap.get(head);

    }
}