class LRUCache {
    public class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int k, int v){
            this.key= k;
            this.value=v;
            this.next= null;
            this.prev= null;
        }
        Node(){
            this.key=-1;
            this.value=-1;
            this.next=null;
            this.prev=null;
        }
    }
    public Node head;
    public Node tail;
    public int cap;
    public HashMap<Integer, Node> map;
    public void addNode(Node n){
        Node nb= head.next;
        head.next= n;
        n.next= nb;
        nb.prev= n;
        n.prev=head;
    }
    public void removeNode(Node n){
        Node nb= n.prev;
        Node nc= n.next;
        nb.next= nc;
        nc.prev= nb;
        n.next= null;
        n.prev=null;
    }
    public void moveFirst(Node n){
        removeNode(n);
        addNode(n);
    }
    public LRUCache(int capacity) {
        cap=capacity;
        map= new HashMap<>();
        head= new Node();
        tail= new Node();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
       Node n1= map.get(key);
       if(n1==null){
           return -1;
       } 
        moveFirst(n1);
        return n1.value;
    }
    
    public void put(int key, int value) {
      Node n1= map.get(key);
      if(n1==null){
          Node n2= new Node(key,value);
          if(map.size()==cap){
              Node n3= tail.prev;
              map.remove(n3.key);
              removeNode(n3);
              addNode(n2);
              map.put(key,n2);
          }
            else{
                addNode(n2);
                map.put(key,n2);
            } 
      }  
    else{
        if(n1.value!=value){
            n1.value=value;
            map.put(key,n1);
        }
        moveFirst(n1);
    }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */