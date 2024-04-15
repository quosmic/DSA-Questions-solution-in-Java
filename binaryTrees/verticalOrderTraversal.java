/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Specs {
        TreeNode val;
        int vDist;
        int yCood;
        Specs(TreeNode l, int d, int c){
            this.val=l;
            this.vDist=d;
            this.yCood=c;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Specs> q= new LinkedList<>();
        HashMap<Integer, Map<Integer, List<Integer>>> map= new HashMap<>();
        List<List<Integer>> list= new ArrayList<>();
        int min=0;
        int max=0;
        int row = 0;
        q.add(new Specs(root,0,0));
        q.add(null);
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
                List<Integer> list1= new ArrayList<>();
                list1.add(curr.val.val);
                Map<Integer, List<Integer>>map1= new HashMap<>();
                map1.put(curr.yCood,list1);
                map.put(curr.vDist, map1);
                }
        else{
            Map<Integer, List<Integer>>map1 = map.get(curr.vDist);
            List<Integer> list1 = new ArrayList<>();
            if(map1.containsKey(curr.yCood)){
            list1 = map1.get(curr.yCood);
            list1.add(curr.val.val);
            Collections.sort(list1);
            map1.put(curr.yCood,list1);
            }
            else{
                list1.add(curr.val.val);
                 map1.put(curr.yCood,list1);
            }
        map.put(curr.vDist, map1);
        }

        
        if(curr.val.left!=null){
            q.add(new Specs(curr.val.left,curr.vDist-1,curr.yCood+1));
             min= Math.min(min, curr.vDist-1);
            row = Math.max(row,curr.yCood+1);
        }
               if(curr.val.right!=null){
        q.add(new Specs(curr.val.right,curr.vDist+1,curr.yCood+1));           
              max= Math.max(max, curr.vDist+1);
              row = Math.max(row,curr.yCood+1);}
            
        }
        }
            
        
        for(int i=min;i<=max;i++){
        Map<Integer,List<Integer>>map3= map.get(i);
        List<Integer> list3= new ArrayList<>();
        for(int j=0;j<=row;j++){
            if(map3.containsKey(j)){
                list3.addAll(map3.get(j));
            }
        }
        
        list.add(list3);
    }
    return list;
    }
        }
    
