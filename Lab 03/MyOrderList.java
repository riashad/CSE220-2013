public class MyOrderList{
  Node cursor = new Node(0,null); 
  Node head = cursor;
  MyOrderList(){
  }
  
  void insert (Node newElement){
    if(head.next == null){
      head = newElement;
      head.next = newElement;
    }
    else{   
      cursor = head;
      if(cursor.next == cursor ){
        newElement.next = cursor;
        cursor.next = newElement;
        if(newElement.key < cursor.key){
          head = newElement;
        }
        return;
      }
      
      for (cursor = head;cursor.next != head;cursor = cursor.next){
        if(newElement.key == cursor.key){
          System.out.println(newElement.key + " Already Exists");
          return;
        }else 
          if(newElement.key > cursor.key && newElement.key < cursor.next.key){
          newElement.next = cursor.next;
          cursor.next = newElement;
          return;
        }
      }
      
      if(cursor.key == newElement.key){
        System.out.println(newElement.key + " Already Exists");
        return;
      }
      
      while(cursor.key < cursor.next.key){
        cursor = cursor.next;
      }
      
      newElement.next = cursor.next;
      cursor.next = newElement;
      if(head.key > newElement.key){
        head = newElement;
      }
    }
  }
  
  /////////////////////////////////////////
  
  Node retrieve (int searchKey){
    for (  cursor = head; cursor.next != head; cursor = cursor.next){
      if(cursor.key == searchKey){
        return cursor;
      }
    }
    if(cursor.key == searchKey){
      return cursor;
    }
    return null;
  }
  
  /////////////////////////////////////////
  
  Node remove (){
    if(isEmpty()){
      return null;
    }
    Node pred = cursor;
    for(; pred != cursor.next; cursor = cursor.next){
    }
    cursor.next = pred.next;
    pred = null;
    return  cursor.next;
  }
  
  ///////////////////////////////////////////
  
  Node remove (int deleteKey){
    if(isEmpty()){
      return null;
    }
    
    for(cursor = head; cursor.next != head; cursor = cursor.next){
      if(cursor.next.key == deleteKey){
        cursor.next = cursor.next.next;
        return cursor.next.next;
      }
    }
    if(head.key == deleteKey){
      cursor.next = head.next;
    }
    return cursor.next;
  }
  
  //////////////////////////////////////////////
  
  void clear (){
    if(isEmpty()){
      System.out.println("Empty List");
    }
    for(cursor = head; cursor != null; cursor = cursor.next){
      remove();
    }
  }
  
  /////////////////////////////////////////////
  boolean isEmpty (){
    if(head == null){
      return true;
    }
    return false;
  }
  
  ////////////////////////////////////////
  
  Node gotoBeginning (){
    if(!isEmpty()){
      for(cursor = head; cursor.key < cursor.next.key; cursor=cursor.next){
      }
      return cursor.next;
    }
    return null;
  }
  
  //////////////////////////////////////////
  
  Node gotoEnd (){
    if(!isEmpty()){
      for(cursor = head; cursor.key < cursor.next.key; cursor=cursor.next){
      }
      return cursor;
    }
    return null;
  }
  
  ////////////////////////////////////////////
  
  Node gotoNext (){
    if(isEmpty()){
      return null;
    }
    return cursor.next;
  }
  
  ////////////////////////////////////////////
  
  Node gotoPrior (){
    if(isEmpty()){
      return null;
    }
    Node n  = cursor;
    for(; n.next != cursor; n = n.next){
    }
    return n;
  }
  
  //////////////////////////////////////
  
  Node getCursor (){
    if(isEmpty()){
      return null;
    }
    return cursor;
  }
  
  ///////////////////////////////////////
  
  public void showList(){
    if(isEmpty()){
      System.out.println("Empty List");
      return;
    }
    cursor = head;
    while(cursor.next != head){
      System.out.println(cursor.key);
      cursor = cursor.next;
    }
    System.out.println(cursor.key);
  }
}



