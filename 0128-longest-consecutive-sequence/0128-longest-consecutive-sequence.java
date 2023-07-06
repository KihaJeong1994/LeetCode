class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        List<Node> firstNodes = new ArrayList<>();
        for(int num : nums){
            Node node = new Node();
            nodeMap.put(num, node);
        }

        for(int num : nodeMap.keySet()){
            if(!nodeMap.containsKey(num-1)){
                firstNodes.add(nodeMap.get(num));
            }
            if(nodeMap.containsKey(num+1)){
                nodeMap.get(num).next = nodeMap.get(num+1);
            }
        }
        int max = 0;
        for(Node node : firstNodes){
            int len = 0;
            while (node!=null){
                len++;
                node = node.next;
            }
            max = Math.max(max,len);
        }
        return max;
    }

    class Node{
        Node next;
    }

}