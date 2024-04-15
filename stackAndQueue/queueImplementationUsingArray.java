public class Solution {
    class Queue {
        int front, rear;
        int []arr;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            // Write your code here.
            if(front== rear){
                arr[rear]=e;
                rear= (rear+1)%arr.length;
            }
        else if((rear+1)%arr.length!=front){
            arr[rear]=e;
            rear= (rear+1)%arr.length;
        }
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            // Write your code here.
            if(front==rear){
                return -1;
            }
        else {
            int temp= arr[front];
            front= (front+1)%arr.length;
        return temp;
        }
        }
    }
}