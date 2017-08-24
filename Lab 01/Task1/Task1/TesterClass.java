import java.util.*;
public class TesterClass{
  public static void main(String []args){
    Scanner roxy = new Scanner(System.in);
    BookRecord data = new BookRecord();
    data.bookArray = new Book [1];
    int c = 0,t=0;
    boolean f=true;
    while(f)
    {
      System.out.println("Enter your choice.\nEnter 0 to exit.\nEnter 1 to Add a Record.\nEnter 2 to Print the Records.\nEnter 3 to Delete a Record.\nEnter 4 to Edit a Record");
      int choice = roxy.nextInt();
      roxy.nextLine();
      if(choice==1)
      {
        if(t==1)
        {
          data.bookArray = data.increaseArray(data.bookArray);
        }
        t = 0;
        System.out.println();
        data.bookArray[c] = new Book();
        System.out.println("Enter the Name : ");
        data.bookArray[c].Name = roxy.nextLine();
        System.out.println("Enter the ID : ");
        data.bookArray[c].Id=Integer.valueOf(roxy.nextLine());
        System.out.println("Enter the Author : ");
        data.bookArray[c].Author=roxy.nextLine();
        System.out.println("Enter the Publisher : ");
        data.bookArray[c].Publisher = roxy.nextLine();
        data.bookArray = data.increaseArray(data.bookArray);
        c++;
      }

      else if(choice==2)
      {
        if(t==0)
        {
          data.bookArray = data.decreaseArray(data.bookArray);
          t++;
        }
        data.sortByName(0);
      }
      else if(choice==3)
      {
        if(t==0)
        {
          data.bookArray = data.decreaseArray(data.bookArray);
          t++;
        }
        System.out.println("Please type Id");
        int i = roxy.nextInt();
        int p = 0;
        int r = 0;
        for(r =0;r<data.bookArray.length;r++)
        {
          if(i==data.bookArray[r].Id)
          {
            p++;
            break;
          }
        }
        if(p==0)
        {
          System.out.println("ID "+i+" does not exist");
        }
        else
        {
          data.DeleteRecord(r,data.bookArray.length);
          System.out.println("ID "+i+" is deleted successfully");
          c--;
        }
      }
      else if(choice==4)
      {
        if(t==0)
        {
          data.bookArray = data.decreaseArray(data.bookArray);
          t++;
        }
        System.out.println("Please type Id");
        int i = roxy.nextInt();
        int p = 0;
        int r = 0;
        for(r =0;r<data.bookArray.length;r++)
        {
          if(i==data.bookArray[r].Id)
          {
            p++;
            break;
          }
        }
        if(p==0)
        {
          System.out.println("ID "+i+" does not exist");
        }
        else
        {
          data.EditRecord(r);
        }
      }
      else if(choice==0)
      {
        break;
      }
      else
      {
        System.out.println("Please see the question.");
      }
    }
  }
}