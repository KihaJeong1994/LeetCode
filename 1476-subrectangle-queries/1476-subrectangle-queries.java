class SubrectangleQueries {

    private int[][] arr;
    private int rows,cols;

    public SubrectangleQueries(int[][] rectangle) {
        arr = rectangle;
        rows = arr.length;
        cols = arr[0].length;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i=row1;i<=row2;i++){
            for(int j=col1;j<=col2;j++){
                arr[i][j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return this.arr[row][col];
    }
}