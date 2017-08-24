import java.util.Scanner;
public class Tester{
  public static void main(String[]args){
    Scanner scanner = new Scanner(System.in);
    MyBSTree m = new MyBSTree();
    String s="";
    do{
      System.out.println("Choose one");
      System.out.println("1.Insert an element");
      System.out.println("2.Retrieve an element");
      System.out.println("3.Remove an element");
      System.out.println("4.Clear the tree");
      System.out.println("5.Binary search tree empty or not");
      System.out.println("6.Show tree");
      int n = scanner.nextInt();
      
      if(n==1){
        System.out.println("Please enter the Element you want to insert...");
        int o = scanner.nextInt();
        TreeElement t = new TreeElement((Integer)o);
        m.insert(t); 
      }
      
      else if(n==2){
        System.out.println("Please enter the Element you want to retrieve");
        int o = scanner.nextInt();
        if(m.retrieve(o)==null){
          System.out.println(o+" doesnot Exist in the Tree!");
        }else{
          System.out.println(m.retrieve(o));
        }
      }
      
      else if(n==3){
        System.out.println("Please enter the Element you wish to remove!");
        int re = scanner.nextInt();
        try{
          m.remove(re);
          System.out.println("The Element is removed from the Tree!");
        }catch(Exception e){
        }
      }
      
      else if(n==4){
        m.clear();
        
      }
      
      else if(n==5){
        if(m.isEmpty()==true)
          System.out.println("The Tree is Empty!");
        else
          System.out.println("The Tree is not Empty!");        
      }
      
      else if(n==6){
        m.showStructure();
      }     
      System.out.println("Do you want to continue?(Y/N)");
      s = scanner.next();
    }
    
    while((s.equals("y")) || (s.equals("Y")));
  }
}
