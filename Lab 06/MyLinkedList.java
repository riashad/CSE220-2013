public class MyLinkedList {
  MyNode[] LinkedListArray;
  ArrayStack FreeNodeList;
  ArrayQueue UsedNodeList;
  
  public MyLinkedList(int size){
    this.LinkedListArray = new MyNode[size];
    this.FreeNodeList = new ArrayStack(size);
    for(int i = 1; i <= size; i++){
      this.FreeNodeList.push(new MyNode());
    }
    this.UsedNodeList = new ArrayQueue(size);
  }
  
  void insert(Object newElement){
   
    try{
       MyNode n = (MyNode)FreeNodeList.pop();
    n.element = newElement;   
    
    MyNode lastNode;
      lastNode = (MyNode)UsedNodeList.peek();
      
      while(lastNode.next != null){
        lastNode = lastNode.next;
      }
      
      lastNode.next = n;
       UsedNodeList.enqueue(n);
    }
    catch(Exception ex){
    }
   
  }
  
  MyNode remove(){
    try{
      MyNode n = (MyNode)UsedNodeList.dequeue();
      FreeNodeList.push(n);
      return n;
    }
    catch(Exception ex){
      return null;
    }
  }
  
  MyNode search(Object searchElement){
    try{
      MyNode printNode = (MyNode)UsedNodeList.peek();    
      
      while(printNode != null){
        if(printNode.element.equals(searchElement))
          return printNode;
        printNode = printNode.next;
      }
    }
    catch(Exception ex){
      return null;
    }
    return null;
  }
  
  void showUsedNodeList(){
    try{
      MyNode printNode = (MyNode)UsedNodeList.peek();
      
      while(printNode != null){
        System.out.println(printNode.element + " ");
        printNode = printNode.next;
      }
    }
    catch(Exception ex){
      System.out.println("The list is empty");
    }
  }
  
  
  void clear(){
    try{
      MyNode removeNode = (MyNode)UsedNodeList.peek();
      while(removeNode!=null){
        MyNode n = (MyNode)UsedNodeList.dequeue();
        FreeNodeList.push(n);
        removeNode = removeNode.next;
      }
    }
    catch(Exception ex){
      System.out.println("The list is empty");
    }
  }
  
  boolean isFullUsedNodeList(){
    return FreeNodeList.isEmpty();
  }
  
  boolean isEmptyUsedNodeList(){
    return UsedNodeList.isEmpty();
  }
  
  boolean isFullFreeNodeList(){
    return UsedNodeList.isEmpty();
  }
  
  boolean isEmptyFreeNodeList(){
    return FreeNodeList.isEmpty();
  }
    
}
