class Solution {
    public int findDuplicate(int[] nums) {
        // https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_Tortoise_and_Hare
        // find cycle
        int hare = 0;
        int tortoise = 0;
        do{
            hare = nums[nums[hare]];
            tortoise = nums[tortoise];
        }while(hare!=tortoise);
        // start another index
        int answer = 0;
        while(answer!=tortoise){
            tortoise = nums[tortoise];
            answer = nums[answer];
        }
        return answer;
        
    }
}