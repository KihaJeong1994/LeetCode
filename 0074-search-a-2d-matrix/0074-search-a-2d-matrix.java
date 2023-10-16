class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, h = matrix.length;
        while (l<h){
            int m = (l+h)/2;
            if(matrix[m][0]<target) l = m+1;
            else h = m;
        }
        // if matrix[l][0] equals target, then return true
        if(l< matrix.length && matrix[l][0]==target) return true;

        // if not equals, l means the index where target should be.
        // if the matrix's first nums is 1, 3 and target is 2,
        // l will be 1, but it should be in matrix[0]
        // so I will check matrix[l-1]
        if(l==0) return false;
        // l-1 row
        return binarySearchExistence(matrix[l-1],target);
    }

    private boolean binarySearchExistence(int[] nums, int target){
        int l = 0, h = nums.length;
        while (l<h){
            int m = (l+h)/2;
            if(nums[m]<target) l = m+1;
            else h = m;
        }
        if(l>= nums.length) return false;
        return nums[l]==target ? true : false;
    }
}