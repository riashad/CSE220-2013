public class ListQueue{
  private Node head;
  private Node tail;  // The reference to the tail node.
  private int  size; //The number of items in this queue.
  
  
//_________________Creating__Empty__Queue____________________________________
  public ListQueue() {
    head = new Node(null);//Creating the dummy head, and set size to 0.
    tail = head; // Tail also refers to dummy head for the empty list.
    size = 0;
  }
  public int size(){
    return size;
  }
  
  
  /**
   * Details::::: Author::::Junayed Hasan:::12101050:::::
   * here, as, enqueue adds the new item at the end of the underlying
   * list, we use the tail node as the predecessor. After adding
   * a new node with the given item in it, update tail and size.
   * Details::::: Author::::Junayed Hasan:::12101050:::::
   * caution::::Notification::::Disabled:::::::::::::::::
   **/
  
  
  public void RegisterPatient(String s, int id){  
    Patient p = new Patient (s, id);
    System.out.println("Registering Patient with Name : "+s+" and ID : "+id+" ...");
    Node n=new Node(p);
    tail.next=n;
    tail=n;
    size++; 
    System.out.println("A Patient has been successfully regestered!");
    System.out.println("*****************************************");
  } 
  
  
  /**
   * Details::::: Author::::Junayed Hasan:::12101050:::::
   * caution::::Notification::::Disabled:::::::::::::::::
   * 1. Precondition: throw exception if queue is empty
   * 2. Save a reference to the front item (head.next.item)
   * 3. Remove the first real node (head.next) and detach from the list.
   * 4. SPECIAL CASE - if the size of the queue was 1, the tail referred to the node that was just removed, so tail must 
   *  now be adjusted to refer to the dummy head
   * 5. Adjust size
   * 6. Return the item saved in step 2
   * Details::::: Author::::Junayed Hasan:::12101050:::::
   * caution::::Notification::::Disabled:::::::::::::::::
   **/
  
//________________________________________________________________________
  public Object ServePatient() throws QueueException {  
    if (size==0)
      throw new  QueueException("There is no Patient!");
    Node n=head.next;
    Object temp=(Object)n.pa;
    head.next=n.next;
    if (n==tail){
      tail=head;
      n.next=null;
      n.element=null;
    }
    size--;
    return temp;  
  }
  
  
//________________________________________________________________________
  public void CancelAll() { 
    for(Node p=head.next;p!=null;p=p.next){
      p.element=null;
      head.next=p.next;
    }
    tail=head;
    size=0;
    System.out.println("All Appointments have been canceled!");
  }
  
//________________________________________________________________________
  public boolean CanDoctorGoHome(){         
    if(size==0){
      return true; 
    }else{
      return false; 
    }
  } 
  
  
//________________________________________________________________________
  public void ShowAllPatient(){ 
    if(size==0){
      System.out.println("There is no Patients!");
    }else{
      Patient [] temp=root();
      for(int i=0;i<size;i++){
      System.out.println(temp[i]);
    }
  }
  }
//_______________________________________________________________________
  public Patient [] root(){
    Patient [] temp=new Patient[size];
    int k=0;
    for(Node n=head.next;n!=null; n=n.next){
      temp[k]=n.pa;
      k++;
    }

   
    for(int i=0; i<temp.length;i++){
      for(int f=i+1;f<temp.length;f++){
        if((temp[i].name.compareTo(temp[f].name))>0){
          Patient tmp=temp[i];
          temp[i]=temp[f];
          temp[f]=tmp;
        }
      }
    }
    return temp;
  }


}
