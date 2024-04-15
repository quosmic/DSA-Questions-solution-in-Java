public static void findPreSuc(Node root, int key)
{
    // code here.
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */
if(root==null){
  
    return;
}

if(root.data==key){
   if(root.right!=null){
   Node n1= inoSuc(root.right);
   suc= n1;
}
if(root.left!=null){
   Node n2= preSuc(root.left);
   pre= n2;
}
    
}
if(root.data>key){
    suc=root;
    findPreSuc(root.left,key);
}

if(root.data<key){
        pre= root;
        findPreSuc(root.right,key);
    }
    
}
public static Node inoSuc(Node node){
Node curr = node;
while(curr.left!=null){
    curr=curr.left;
}
    return curr;    

}
public static Node preSuc(Node node){

Node curr= node;
while(curr.right!=null){
    curr= curr.right;
}
return curr;    
}

  