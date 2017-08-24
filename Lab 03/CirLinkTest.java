public class CirLinkTest{
  public static void main(String [] args){
    MyOrderList L = new MyOrderList();
    L.insert(new Node (5,null));
    L.insert(new Node (4,null));
    L.insert(new Node (4,null));
    L.insert(new Node (2,null));
    L.insert(new Node (7,null));
    L.insert(new Node (1,null));
    L.insert(new Node (6,null));
    L.insert(new Node (8,null));
//    System.out.println(L.retrieve(4));
//    System.out.println(L.remove());
//    System.out.println(L.remove(5));
    L.showList();
  }
}