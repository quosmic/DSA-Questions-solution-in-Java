class Solution {
    public void saveBoard(char grid[][], List<List<String>> list){
        String ans = "";
        List<String> list1 = new ArrayList<>();
        for(int i = 0;i<grid.length;i++){
            ans= "";
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='Q'){
                ans+= 'Q';
                }
            else ans+= '.';
            }
            list1.add(ans);
        }
    list.add(new ArrayList<>(list1));
    }
    public boolean isSafe(char board[][], int row, int col){
        //horizontal
       for(int j=0; j<board.length; j++) {
           if(board[row][j] == 'Q') {
               return false;
           }
       }
      
       //vertical
       for(int i=0; i<board.length; i++) {
           if(board[i][col] == 'Q') {
               return false;
           }
       }
      
       //upper left
       int r = row;
       for(int c=col; c>=0 && r>=0; c--, r--) {
           if(board[r][c] == 'Q') {
               return false;
           }
       }
      
       //upper right
       r = row;
       for(int c=col; c<board.length && r>=0; r--, c++) {
           if(board[r][c] == 'Q') {
               return false;
           }
       }
      
       //lower left
       r = row;
       for(int c=col; c>=0 && r<board.length; r++, c--) {
           if(board[r][c] == 'Q') {
               return false;
           }
       }
      
       //lower right
       for(int c=col; c<board.length && r<board.length; c++, r++) {
           if(board[r][c] == 'Q') {
               return false;
           }
       }
      
       return true;
   }


    public void helper(char grid[][], int col, List<List<String>> list){
        if(col==grid.length){
            saveBoard(grid,list);
        }
    for(int row=0;row<grid.length;row++){
        if(isSafe(grid, row,col)){
            grid[row][col]= 'Q';
            helper(grid,col+1,list);
            grid[row][col]='.';
        }
    }
    }
    public List<List<String>> solveNQueens(int n) {
    char grid[][]= new char[n][n];
    List<List<String>> list = new ArrayList<>();
    helper(grid,0,list);
    return list;    
    }
}