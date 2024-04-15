class MinStack {
    public class Pair{
        int val;
        int mini;
        Pair(int v, int m){
            this.val= v;
            this.mini=m;
        }
    }
    public Stack<Pair> s;
    public MinStack() {
        s= new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
        s.push(new Pair(val,val));
        }
    else{
        Pair p= s.peek();
        if(p.mini<val){
            s.push(new Pair(val,p.mini));
        }
        else{
            s.push(new Pair(val,val));
        }
    }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        Pair p= s.peek();
        return p.val;
    }
    
    public int getMin() {
        Pair p= s.peek();
        return p.mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */