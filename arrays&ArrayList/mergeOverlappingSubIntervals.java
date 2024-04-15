class Solution {
    public int[][] merge(int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n= intervals.length;
        int count=1;
        for(int i=0;i<n-1;i++){
            if(intervals[i][1]>=intervals[i+1][0] && 
            intervals[i][1]<=intervals[i+1][1]){
                intervals[i+1][0]=intervals[i][0];
                intervals[i][0]= -1;
                intervals[i][1]= -1;
            }
           else if(intervals[i+1][0]<=intervals[i][1] && 
            intervals[i+1][1]<=intervals[i][1]&&intervals[i][0]<=intervals[i+1][0]){
                intervals[i+1][0]=intervals[i][0];
                intervals[i+1][1]=intervals[i][1];
                intervals[i][0]= -1;
                intervals[i][1]= -1;
            }
            else{
                count++;
            }
        }
    int[][] ans= new int[count][2];
    int i=0;
    for(int j=0;j<intervals.length && i<count;j++){
        if(intervals[j][0]!=-1&&intervals[j][1]!=-1){
            ans[i][0]= intervals[j][0];
            ans[i][1]= intervals[j][1];
            i++;
        }
    }
    return ans;
    }
}