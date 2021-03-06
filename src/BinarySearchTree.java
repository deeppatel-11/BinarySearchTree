class BinarySearchTree { 
  
    class BNode { 
        int value; 
        BNode left, right; 
  
        public BNode(int item) { 
            value = item; 
            left = right = null; 
        } 
    } 
  
    // Root of BST 
    BNode root; 
  
    
    BinarySearchTree() {  
        root = null;  
    } 
  
    // This method mainly calls insertRec() 
    void insert(int key) { 
       root = insertRec(root, key); 
    } 
      
    /* A recursive function to insert a new key in BST */
    BNode insertRec(BNode root, int key) { 
  
      
       
        if (root == null) { 
            root = new BNode(key); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (key < root.value) 
            root.left = insertRec(root.left, key); 
        else 
            root.right = insertRec(root.right, key); 
  
        /* return the (unchanged) node pointer */
        return root; 
    } 
   //This method calls inorderRec()
    void inorder()  { 
       inorderRec(root); 
    } 
  
    //utility function to do inorder traversal of BST
    void inorderRec(BNode root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.print(root.value);
            System.out.print("--> ");
            inorderRec(root.right); 
        } 
    } 
    
    void searchNode(int key) {
    	search(root, key);
    }
 
    public BNode search(BNode root, int key) 
    { 
        // Base Cases: root is null or key is present at root 
        if (root==null || value==key) {
            return root; 
        }
        
        if (root.value > key) 
            return search(root.left, key); 
      
         
        return search(root.right, key); 
    }
    void deleteNode(int key) {
    	delete(root,key);
    }
    public BNode delete(BNode node, int key) {
    	if(node==null)
    		return null;
    	if(key< node.value)
    		node.left = delete(node.left,key);
    	     else if(key> node.value)
    		    node.right = delete(node.right,key);
    	    else {
    		if(node.left==null || node.right==null) {
    			System.out.println(" Deleting : "+ key);
    			BNode temp = null;
    			temp = node.left == null? node.right , node.left;
    			
    			if(temp == null)
    				return null;
    			else
    				return node;
    		}
    	
    	else {
    		BNode successor = getSuccessor(node);
    		node.value = successor.value;
    		node.right = delete(node.right, successor.value);
    		return node;
    	}
    }
    return node;
  }
    public BNode getSuccessor(BNode node) {
    	if(node == null)
    		return null;
    	BNode temp = node.right;
    	while(temp !=null)
    		temp = temp.left;
    	return temp;
    	
    }
}
