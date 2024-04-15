class Solution {
    public void flood(int[][] image, int sr, int sc, int color, int target){
        if(sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length - 1 || image[sr][sc]  != target|| image[sr][sc] == color ){
            return;
        }
    image[sr][sc]= color;
    flood(image, sr-1,sc,color,target);
    flood(image, sr+1,sc,color,target);
    flood(image,sr,sc+1,color,target);
    flood(image,sr,sc-1,color,target);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target=image[sr][sc];
        flood(image,sr,sc,color,target);
        return image;
    }
}