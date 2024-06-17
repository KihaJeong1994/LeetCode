class Solution {
    public int longestConsecutive(int[] nums) {
        // should run in O(n)
        //        0 <= nums.length <= 10**5
        //        -10**9 <= nums[i] <= 10**9
        
        // answer will be between 1~nums.length
        // nums = [100,4,200,1,3,2]
        // make DoubleLinkedList Node
        // for loop
        // 100 -> check 99 or 101
        // 99 -> before, 101 -> after
        if(nums.length==0) return 0;
        Map<Integer, Node> nodeMap = new HashMap<>();
        for(int num : nums){
            if(!nodeMap.containsKey(num)){
                nodeMap.put(num, new Node(num));
                // if there is num-1 Node
                if(nodeMap.containsKey(num-1)){
                    nodeMap.get(num).prev = nodeMap.get(num-1);
                    nodeMap.get(num-1).next = nodeMap.get(num);
                }
                // if there is num+1 Node
                if(nodeMap.containsKey(num+1)){
                    nodeMap.get(num).next = nodeMap.get(num+1);
                    nodeMap.get(num+1).prev = nodeMap.get(num);
                }
            }
        }
        int maxLength = 1;
        Set<Integer> nodeCheckMap = new HashSet<>();
        for(int num: nums){
            int length = 1;
            if(!nodeCheckMap.contains(num)){
                nodeCheckMap.add(num);
                Node currentNode = nodeMap.get(num);
                Node nextCheck = currentNode;
                Node prevCheck = currentNode;
                while (nextCheck.next!=null){
                    length++;
                    nextCheck = nextCheck.next;
                    nodeCheckMap.add(nextCheck.num);
                }
                while (prevCheck.prev!=null){
                    length++;
                    prevCheck = prevCheck.prev;
                    nodeCheckMap.add(prevCheck.num);
                }
            }
            if(length>maxLength) maxLength = length;
        }
        return maxLength;
        
    }
    
    static class Node{
        int num;
        Node prev;
        Node next;
        Node(int num){
            this.num = num;
        }
    }

}