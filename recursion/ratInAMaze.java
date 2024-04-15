class Solution {
    public static void path(int[][] m, int i, int j, String str, ArrayList<String> list, boolean vis[][]){
        
      
    if(i==m.length-1&&j==m.length-1){
        list.add(str);
        return;
    }
        
        
        if(i+1<m.length && !vis[i+1][j] && m[i+1][j]==1 ){
        vis[i+1][j]=true;
        path(m,i+1,j,str+'D',list,vis);
        vis[i+1][j]= false;
            
        }
        if(i-1>=0 && !vis[i-1][j] && m[i-1][j]==1){
        vis[i-1][j]= true;
        path(m,i-1,j,str+'U',list,vis);
        vis[i-1][j]= false;
            
        }
        if(j-1>=0 && !vis[i][j-1] && m[i][j-1]==1){
        vis[i][j-1]= true;
        path(m,i,j-1,str+'L',list,vis);
        vis[i][j-1]= false;
            
        }
    
        if(j+1<m.length && !vis[i][j+1] && m[i][j+1]==1){
        vis[i][j+1] =true;
        path(m,i,j+1,str+'R',list,vis);
        vis[i][j+1]= false;
            
        

    }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        String ans = "";
        boolean vis[][]= new boolean[n][n];
        vis[0][0]=true;
        if(m[0][0]==1){
        path(m,0,0,ans,list,vis);
        }
        return list;
    }
}