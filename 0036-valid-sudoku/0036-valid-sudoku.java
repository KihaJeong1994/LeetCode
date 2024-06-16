class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 1. check row
        for(int i=0; i<9; i++){
            if(!isValidRow(i, board)){
                return false;
            }
        }
        
        // 2. check column
        for(int j=0; j<9; j++){
            if(!isValidColumn(j, board)){
                return false;
            }
        }
        
        // 3. check box
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                if(!isValidBox(i,j, board)){
                    return false;
                }
            }
        }
        
        
        return true;
    }

    private boolean isValidBox(int i, int j, char[][] board) {
        Set<Character> setToCheck = new HashSet<>();
        for(int k=0; k<3; k++){
            for(int l=0; l<3; l++){
                char cell = board[i+k][j+l];
                if(cell != '.'){
                    if(setToCheck.contains(cell)){
                        return false;
                    }else{
                        setToCheck.add(cell);
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidColumn(int j, char[][] board) {
        Set<Character> setToCheck = new HashSet<>();
        for(int i=0; i<9; i++){
            char cell = board[i][j];
            if(cell != '.'){
                if(setToCheck.contains(cell)){
                    return false;
                }else{
                    setToCheck.add(cell);
                }
            }
        }
        return true;
    }

    private boolean isValidRow(int i, char[][] board) {
        // declare set to count 1~9
        // if there is already num in set -> return false
        // else put in set
        Set<Character> setToCheck = new HashSet<>();
        for(int j=0; j<9; j++){
            char cell = board[i][j];
            if(cell != '.'){
                if(setToCheck.contains(cell)){
                    return false;
                }else{
                    setToCheck.add(cell);
                }
            }
        }
        return true;
    }
}