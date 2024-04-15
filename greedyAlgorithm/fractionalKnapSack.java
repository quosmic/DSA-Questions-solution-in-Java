/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        double[][] ans1= new double[n][2];
        for(int i=0;i<n;i++){
            ans1[i][0]=i;
            ans1[i][1]=arr[i].value/(double)arr[i].weight;
        }
    Arrays.sort(ans1,Comparator.comparingDouble(o->o[1]));
        double profit=0;
        int weight=W;
        for(int i=n-1;i>=0;i--){
            int idx= (int) ans1[i][0];
            if(weight>arr[idx].weight){
                profit+=arr[idx].value;
                weight-=arr[idx].weight;
            }
        else{
            profit+=ans1[i][1]*weight;
            break;
        }
        }
    return profit;
        
    }
}