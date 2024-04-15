class LRUCache {
    Queue<Integer> q;
    Map<Integer,Integer> map;
    int Cap;
    int count=0;
    public LRUCache(int capacity) {
        Cap= capacity;
        q= new LinkedList<>();
        map= new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            q.remove(key);
            q.add(key);
            return map.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        
    if(map.containsKey(key)){
        q.remove(key);
        q.add(key);
        map.put(key,value);
    }
    else {
         if(count==Cap){
            map.remove(q.remove());
            q.add(key);
          map.put(key,value); 
        }
    else{
        count++;
        q.add(key);
          map.put(key,value);     
    }
    }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */