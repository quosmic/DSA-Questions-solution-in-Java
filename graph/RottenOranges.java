class Solution {
    public class Node {
        int row;
        int col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==2) {
                    q.add(new Node(i,j));
                }
            }
        }
        int n = grid.length;
        int m = grid[0].length;
        while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
        Node curr = q.remove();
        int row = curr.row;
        int col = curr.col;

        // Check all four directions
        if (row + 1 < n && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 2;
            q.add(new Node(row + 1, col));
        }
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            grid[row - 1][col] = 2;
            q.add(new Node(row - 1, col));
        }
        if (col + 1 < m && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 2;
            q.add(new Node(row, col + 1));
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 2;
            q.add(new Node(row, col - 1));
        }
    }
    minutes++; 
}
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++){
            if(grid[i][j]==1){
                return -1;
            }
        }
    }
    return (minutes > 0) ? minutes - 1 : 0;
    }
}