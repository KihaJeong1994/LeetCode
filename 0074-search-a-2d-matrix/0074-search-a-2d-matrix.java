class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // search in the first integer of each row first O(log m)
        int row = getRow(matrix, target);
        if(row==-1){
            return false;
        }
        if(matrix[row][0]==target){
            return true;
        }
        // search in that row next O(log n)
        int l = 0;
        int r = matrix[row].length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[row][mid]<target){
                l = mid+1;
            }else if(matrix[row][mid]>target){
                r = mid -1;
            }else{
                return true;
            }
        }
        return false;
    }
    
    private int getRow(int[][] matrix, int target){
        int t = 0;
        int b = matrix.length-1;
        while(t<=b){
            int mid = (t+b)/2;
            int firstNum = matrix[mid][0];
            if(firstNum<target){
                t = mid+1;
            }else if(firstNum>target){
                b = mid-1;
            }else{
                return mid;
            }
        }
        if(t>=matrix.length){
            return t-1;
        }
        if(b<0){
            return 0;
        }
        if(matrix[t][0]<target){
            return t;
        }else{
            return t-1;
        }
        
    }
}