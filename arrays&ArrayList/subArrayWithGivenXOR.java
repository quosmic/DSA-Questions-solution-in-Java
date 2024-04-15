public class Solution {
    public int solve(int[] A, int B) {
    HashMap<Integer, Integer> map= new HashMap<>();
    int xor=0;
    int count=0;
    for(int i=0;i<A.length;i++){
        xor= xor^A[i];
        if(map.containsKey(xor^B)){
            count+=map.get(xor^B);
        }
        if(map.containsKey(xor)){
            map.put(xor,map.get(xor)+1);
        }
        else{
            map.put(xor,1);
        }       
         if(xor==B){
            count++;
        }
        }
    return count;
    }
}

