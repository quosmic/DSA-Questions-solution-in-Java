class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
      Arrays.sort(arr,(a,b)->(b.profit-a.profit));// sorting in dec order on the basis of Profit
        int count = 0;
        int profit = 0;
        int deadline = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].deadline>deadline){
                deadline=arr[i].deadline;
            }
        }
        boolean vis[] = new boolean[deadline+1];
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(!vis[j]){
                vis[j]= true;
                profit = profit + arr[i].profit;
                count++;
                break;
                }
                }
        } 
    int ans[] = {count,profit};
    return ans;
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/