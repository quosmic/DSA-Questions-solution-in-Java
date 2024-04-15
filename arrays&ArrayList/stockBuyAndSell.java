class Solution {
    public int maxProfit(int[] prices) {
      int maxi= Integer.MAX_VALUE;
      int maxProf= Integer.MIN_VALUE;
      for(int i=0;i<prices.length;i++){
          if(maxi<prices[i]){
              maxProf= Math.max(maxProf,prices[i]-maxi);
          }
        else{
            maxi= prices[i];
        }
      }  
    return maxProf!=Integer.MIN_VALUE?maxProf:0;
    }
}