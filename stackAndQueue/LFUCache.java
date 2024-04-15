class LFUCache {
    public class Node{
        int key;
        int val;
        int freq;
        Node(int k, int v, int f){
            this.key= k;
            this.freq= f;
            this.val= v;
        }
    }
    public Map<Integer, Node> keyVal;
    public Map<Integer,LinkedHashSet<Integer>> freqKey;
    public int min=1;
    public int cap;
    public LFUCache(int capacity) {
        cap=capacity;
        keyVal= new HashMap<>();
        freqKey= new HashMap<>();
        freqKey.put(1,new LinkedHashSet<>());
    }
    
    public int get(int key) {
        Node n= keyVal.get(key);
        
        if(n==null){
            return -1;
        }
        
        freqKey.get(n.freq).remove(key);
        if(n.freq==min&&freqKey.get(n.freq).size()==0){
            min++;
        }
        n.freq= n.freq+1;
        if(!freqKey.containsKey(n.freq)){
            freqKey.put(n.freq, new LinkedHashSet<>());
        }
        freqKey.get(n.freq).add(key);
        keyVal.put(key,n);
        return keyVal.get(key).val;
    }
    
    public void put(int key, int value) {
       
       Node n= keyVal.get(key);
         if(n==null){
            if(keyVal.size()>=cap){
                int k1= freqKey.get(min).iterator().next();//linkedHashSetIteration
                freqKey.get(min).remove(k1);
                keyVal.remove(k1);
            }
            
                Node n1= new Node(key,value,1);
                keyVal.put(key,n1);
                min=1;
                freqKey.get(1).add(key);
            
        }
        else{
            n.val= value;
            keyVal.put(key,n);
            int num= get(key);
            return;
        }
               
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */