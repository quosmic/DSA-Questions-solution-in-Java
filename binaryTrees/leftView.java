//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
     class Specs{
        Node val;
        int vDist;
        Specs(Node l, int d){
            this.val=l;
            this.vDist=d;
        }
    }
    void left(Node root, ArrayList<Integer> list){
        
        Queue<Specs> q = new LinkedList<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        q.add(new Specs(root,0));
        q.add(null);
        int mini=0;
        while(!q.isEmpty()){
            Specs curr = q.remove();
       
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
            else {
                q.add(null);
            }
            }
        else{
            if(!map.containsKey(curr.vDist)){
                map.put(curr.vDist,curr.val.data);
                mini++;
            }
        if(curr.val.left!=null){
            q.add(new Specs(curr.val.left,curr.vDist+1));
        }
               if(curr.val.right!=null){
        q.add(new Specs(curr.val.right,curr.vDist+1));        }   
 
            
        }
            
        }
    for(int i=0;i<=mini;i++){
        if(map.containsKey(i))
        list.add(map.get(i));
    }
    }
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer>list= new ArrayList<>();
      if (root == null) {
            return list;
        }

      left(root, list);
      return list;
    }
}