class SubrectangleQueries {

    private int[][] arr;
    private int rows,cols;

    public SubrectangleQueries(int[][] rectangle) {
        arr = rectangle;
        rows = arr.length;
        cols = arr[0].length;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i>=row1 && i<=row2 && j>=col1 && j<=col2){
                    arr[i][j] = newValue;
                }
            }
        }
    }
    
    public int getValue(int row, int col) {
        return this.arr[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */