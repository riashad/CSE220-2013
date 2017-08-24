import java.util.Scanner;
public class Tester{
  public static void main(String[]args){
    Scanner roxy = new Scanner(System.in);
    System.out.println("Enter the size of MyLinkedList");
    int n = roxy.nextInt();
    String s = "";
    MyLinkedList m = new MyLinkedList(n);
    do{
      System.out.println("____@@@@@_____MENU____@@@@@@____"+"\n1."+"\tInsert an element"+"\n2."+"\tRemove an element"+"\n3."+"\tSearch an element"+"\n4."+"\tClear the elements");
      System.out.println("5."+"\tCheck if UsedNodeList is full"+"\n6."+"\tCheck if UsedNodeList is empty"+"\n7."+"\tCheck if FreeNodeList is full"); 
      System.out.println("8."+"\tCheck if FreeNodeList is empty"+"\n9."+"\tShow UsedNodeList"); 
      
      int input = roxy.nextInt();
      if(input==1){
        System.out.println("Enter an Object");
        Object o = roxy.next();
        m.insert(o);
      }else if(input==2){
        System.out.println(m.remove());
      }else if(input==3){
        System.out.println("Enter the object you want to search");
        Object o = roxy.next();
        MyNode searchedNode = m.search(o);
        if(searchedNode != null)
          System.out.println("The searched node is : " + searchedNode.element);
        else
          System.out.println("No node found!");
      }else if(input==4){
        m.clear();
      }else if(input==5){
        System.out.println(m.isFullUsedNodeList());
      }else if(input==6){
        System.out.println(m.isEmptyUsedNodeList());
      }else if(input==7){
        System.out.println(m.isFullFreeNodeList());
      }else if(input==8){
        System.out.println(m.isEmptyFreeNodeList());
      }else if(input==9){
        m.showUsedNodeList();
      }System.out.println("Do you want to continue?(Y/N)");
      s = roxy.next();
    }while((s.equals("y")) || (s.equals("Y"))); 
  }
}
