public class Solution{
    static class Stack {
        public int root[];
        public int count=0;
        Stack(int capacity) {
            // Write your code here.
        root= new int[capacity];
        }
        public void push(int num) {
            // Write your code here.
        
     
        if(count<root.length){
            root[count]=num;
            count++;
        }
        }
        public int pop() {
            // Write your code here.
        if(count==0){
            return -1;
        }
        
        int temp= root[count-1];
        count--;
        return temp;
        }
        public int top() {
            // Write your code here.
        if(count==0){
            return -1;
        }
        else return root[count-1];
        }
        public int isEmpty() {
            // Write your code here.
            if(count==0){
                return 1;
            }
        else return 0;
        }
        public int isFull() {
            // Write your code here.
            if(count==root.length){
                return 1;
            }
        else return 0;
        }
    }
}