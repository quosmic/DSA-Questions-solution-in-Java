class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<Integer> ans= new ArrayList<>();
        int[][] ans1= new int[n][3];
        for(int i=0;i<n;i++){
            ans1[i][0]=i;
            ans1[i][1]=start[i];
            ans1[i][2]= end[i];
        }
        Arrays.sort(ans1,Comparator.comparingDouble(o->o[2]));
        int lastEnd=-1;
        
        ans.add(ans1[0][0]);
        lastEnd= ans1[0][2];
        for(int i=1;i<n;i++){
            if(ans1[i][1]>lastEnd){
                ans.add(ans1[i][0]);
                lastEnd= ans1[i][2];
            }
        }
        return ans.size();
    }
}