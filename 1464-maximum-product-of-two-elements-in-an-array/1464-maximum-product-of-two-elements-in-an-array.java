class Solution {
    public int maxProduct(int[] nums) {
        // easy way
        // 1. sort the nums by descending order
        // 5 4 3 2
        // 2. multiply the first and second one
        // O(Nlog(N))
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-1]-1)*(nums[n-2]-1);
    }
}