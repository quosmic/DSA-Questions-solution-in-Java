class MyQueue {
    public Stack<Integer> s1;
    public Stack<Integer> s2;
    public MyQueue() {
        s1= new Stack<>();
        s2= new Stack<>();
    }
    
    public void push(int x) {
        if(empty()){
            s1.push(x);
            return;
        }
        if(!s1.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        s1.push(x);
        while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        return;
        }
    else{
        if(!s2.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        s2.push(x);
        while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        return;
        }
    }
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        if(!s1.isEmpty()){
            return s1.pop();
        }
    else return s2.pop();
    }
    
    public int peek() {
    if(empty()){
            return -1;
        }
    if(!s1.isEmpty()){
            return s1.peek();
        }
    else return s2.peek();    
    }
    
    public boolean empty() {
        return (s1.isEmpty()&&s2.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */