public class MyNode {
  Object element;
  MyNode next;
  
  public MyNode(){ //Default Constructor
  }
  
  public MyNode(Object element) { //Constructor of receiving elements
    this.element = element;
    this.next = null;
  }
}