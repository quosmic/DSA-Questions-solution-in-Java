import java.util.*;
public final class Solution {
    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(maxHeap.isEmpty()||maxHeap.peek()>matrix[i][j]){
                    maxHeap.add(matrix[i][j]);
                }
                else{
                    minHeap.add(matrix[i][j]);
                }
                if(maxHeap.size()-minHeap.size()>1){
                    minHeap.add(maxHeap.remove());
                }
                if(minHeap.size()-maxHeap.size()>1){
                    maxHeap.add(minHeap.remove());
                }
            }
        }
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2;
        }
        else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else{
            return minHeap.peek();
        }
    }
}