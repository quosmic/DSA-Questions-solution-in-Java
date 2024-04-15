
/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
    static class Specs{
        Node val;
        int vDist;
        Specs(Node l, int d){
            this.val=l;
            this.vDist=d;
        }
    }
    static void left(Node root, ArrayList<Integer> list){
        
        Queue<Specs> q = new LinkedList<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        q.add(new Specs(root,0));
        q.add(null);
        int min=0;
        int max=0;
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
                }
        if(curr.val.left!=null){
            q.add(new Specs(curr.val.left,curr.vDist-1));
             min= Math.min(min, curr.vDist-1);

        }
               if(curr.val.right!=null){
        q.add(new Specs(curr.val.right,curr.vDist+1));           
              max= Math.max(max, curr.vDist+1);}
            
        }
            
        }
    for(int i=min;i<=max;i++){
        list.add(map.get(i));
    }
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
       ArrayList<Integer>list= new ArrayList<>();
      if (root == null) {
            return list;
        }

      left(root, list);
      return list;
    }  
    }
