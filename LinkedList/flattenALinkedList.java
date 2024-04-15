class GfG
{
    Node merge(Node head1,Node head2){
        Node idx1=head1;
        Node idx2=head2;
        Node Noder= new Node(-1);
        Node newNode = Noder;
        while(idx1!=null&&idx2!=null){
            if(idx1.data<idx2.data){
                newNode.bottom= idx1;
                newNode= newNode.bottom;
                idx1=idx1.bottom;
            }
        else{
             newNode.bottom= idx2;
                newNode= newNode.bottom;
                idx2=idx2.bottom;
        }
            
        }
    while(idx1!=null){
        newNode.bottom= idx1;
                newNode= newNode.bottom;
                idx1=idx1.bottom;
    }
     while(idx2!=null){
          newNode.bottom= idx2;
                newNode= newNode.bottom;
                idx2=idx2.bottom;
     }   
    return Noder.bottom;
        
    }
    Node flatten(Node root)
    {
	// Your code here
	if(root==null||root.next==null){
	    return root;
	}
    root.next= flatten(root.next);
    return merge(root,root.next);
    }
}