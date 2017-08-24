
public class MyBSTree{
  public TreeElement root;
  MyBSTree (){
    root=null;
  }
  /**
   void insert (TreeElement newElement)
   Pre-condition:
   The newElement is not null.
   Post-condition:
   This method inserts newElement into a Binary Search Tree.
   If an element with the same key as newElement already exists in the tree,
   then it concludes the key already exists and do not insert the key in
   the Binary Search Tree. 
   **/
  
  public void insert (TreeElement newElement){
    if(root==null){
      root=newElement;
    } 
    else{
      TreeElement n=root;// for keep tracking with child tree  
      TreeElement parent=null;
      while(n!=null){
        if(newElement.element==n.element){
          return;
        }
        if((newElement.element)>(n.element)){
          parent=n;
          n=n.right;
        }else{
          parent=n;
          n=n.left;
        }
      }
      if((newElement.element)>(parent.element)){
        parent.right=newElement;
      }else{
        parent.left=newElement;
      }
    }
  }
  
  /**
   TreeElement retrieve (int searchKey) 
   Pre-condition:   
   The tree is not empty. 
   Post-condition:
   It searches the binary search tree for the TreeElement with key searchKey.
   If this TreeElement is found, then returns the TreeElement. Otherwise, returns null. 
   **/
  
  public TreeElement retrieve (int searchKey){
    if(root==null){
      return null;
    }
    TreeElement n=root;
    TreeElement parent=null;
    while(n!=null){
      if(searchKey==n.element){
        return n;
      }
      if((searchKey)>(n.element)){
        parent=n;
        n=n.right;
      }else{
        parent=n;
        n=n.left;
      }
    }
    return  null;
  }
  
  
  public TreeElement findParent(int key){
    TreeElement n=root;
    TreeElement parent=null;
    if(n==null){
      return null;
    }else{
      while(n!=null){
        if(n.element==key){
          break;
        }if(key>n.element){
          parent=n;
          n=n.right;
        }else{
          parent=n;
          n=n.left;
        }
      }
    }
    return parent;
  }
  
  
  public  TreeElement findLeftMost( TreeElement  n){
    if(n.left==null){
      return n;
    }else{
      
      return  findLeftMost(n.left);
    }
  }
  
  /**
   TreeElement remove (int deleteKey) 
   Pre-condition:
   The tree is not empty. 
   Post-condition:
   This method deletes the element with key deleteKey from a binary search tree,
   if it exists in the tree. Otherwise, returns null. 
   **/
  
  public TreeElement remove(int deleteKey){  
    TreeElement  r=retrieve(deleteKey); //find out the key  which we want to remove
    TreeElement parent=findParent(deleteKey);
    if(r==null){
      System.out.println("There is no such element to remove!");
    }
    if(r.left==null&&r.right==null){
      if((r.element)<(parent.element)){
        parent.left=null;
      }else{
        parent.right=null;
      }
    }
    if(r.right!=null&&r.left!=null){
      TreeElement  tr=findLeftMost(r.right);
      TreeElement  temp=r;
      r.element=tr.element;
      return  temp;
    }
    if(r.right!=null&&r.left==null){
      parent.right=r.right;
      //r=null;
    }
    if(r.right==null&&r.left!=null){
      parent.left=r.left;
      //r=null;
      
    }
    return r;
  }
  
  /**
   void clear ()
   Pre-condition:
   None.
   Post-condition:
   This method removes all the elements from the binary search tree. 
   **/
  
  public void clear (){
    if(root==null)
      System.out.println("Yo! The tree is already Null Man!");
    else{
      root=null;
      System.out.println("The Tree has been Cleared!");
    }
    
  }
  
  /**
   boolean isEmpty ()
   Pre-condition:
   None.
   Post-condition:
   This method returns true if a binary search tree is empty. Otherwise, returns false. 
   **/
  
  public boolean isEmpty (){
    if(root==null){
      return true;
    }
    else{
      return false;
    }
  }
  
  
  public void preorder(TreeElement n){
    if(n==null){
      return;
    }
    
    else{ 
      System.out.print (n.element+" ");
      preorder (n.left); 
      preorder(n.right);
    }
  }
  
  public void inorder(TreeElement n){
    if(n==null){
      return;
    }
    
    else{ 
      inorder(n.left);
      System.out.print(n.element+" "); 
      inorder(n.right);
      
    }
  } 
  
  public void postorder(TreeElement n){
    if(n==null){
      return;
    }
    
    else{ 
      
      postorder (n.left); 
      postorder(n.right);
      System.out.print (n.element+" ");
    }
  }
  
  /**
   void showStructure ()
   Precondition:
   None.
   Postcondition:
   This method prints the keys of the Binary Search Tree in pre-order, in-order and post-order.
   If the list is empty, then outputs “Empty Tree”. 
   **/
  
  public void showStructure (){
    if(root==null){
      System.out.println("The tree is Empty!!!");
    }else{
      System.out.print("PreOrder : ");
      preorder(root);
      System.out.println(); 
      System.out.print("InOrder : ");
      inorder(root);
      System.out.println();
      System.out.print("PostOrder : ");
      postorder(root);
      System.out.println();
    }
  }
}
