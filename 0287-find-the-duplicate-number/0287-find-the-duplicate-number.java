class Solution {
    public int findDuplicate(int[] nums) {
        // phase 1
        int start = nums[0];
        int hair = start;
        int tortoise = start;
        while(true){
            hair = nums[nums[hair]];
            tortoise = nums[tortoise];
            if(hair==tortoise){
                // phase 2
                tortoise = start;
                while(hair!=tortoise){
                    hair = nums[hair];
                    tortoise = nums[tortoise];
                }
                return hair;
            }
        }
    }
}