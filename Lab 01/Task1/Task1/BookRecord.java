import java.util.*;
public class BookRecord{
  Book [] bookArray;
  
  
  void print(){
    for(int c=0;c<bookArray.length;c++){
      System.out.println(bookArray[c].toString());
    }
  }
  
  
  
  void sortByName(int n){
    Book temp;
    for(int i=0;i<bookArray.length;i++){
      for(int j=1;j<bookArray.length;j++){
        if(bookArray[j-1].Name.compareToIgnoreCase(bookArray[j].Name)>0){
          temp=bookArray[j-1];
          bookArray[j-1]=bookArray[j];
          bookArray[j]=temp;
        } else if(bookArray[j-1].Name.compareToIgnoreCase(bookArray[j].Name)==0){
          if(bookArray[j-1].Id>bookArray[j].Id)
          {
            temp = bookArray[j-1];
            bookArray[j-1] = bookArray[j];
            bookArray[j] = temp;
          }   
        }
      }
    }
    if(n==0){
      print();
    }
  }
  
  
  
  
  public Book [] increaseArray(Book [] theArray)  
  {  
    int i = theArray.length;  
    int n = ++i;  
    Book[] newArray = new Book[n];  
    for(int c=0;c<theArray.length;c++)
    {  
      newArray[c] = theArray[c];  
    }  
    return newArray;
  }
  
  
  
  public void DeleteRecord(int r,int t)
  {
    Book [] y = new Book [t-1];
    int d = 0;
    for(int c=0;c<t;c++){
      if(!(c==r))
      {
        y[d] = bookArray[c];
        d++;
      }
    }
    bookArray = y;
    sortByName(1);
  }
  
  
  
  Scanner roxy = new Scanner(System.in);
  public void EditRecord(int r)
  {
    System.out.println("which record do you want to edit?");
    System.out.println("If Name then please type 1");
    System.out.println("If ID then please type 2");
    System.out.println("If Author then please  type 3");
    System.out.println("If Publisher then please  type 4");
    int o = roxy.nextInt();
    if(o==1)
    {
      System.out.println("Please type new Name");
      bookArray[r].Name = roxy.next();
    }
    else if(o==2)
    {
      System.out.println("please type new ID");
      bookArray[r].Id = roxy.nextInt();
    }
    else if(o==3)
    {
      System.out.println("please type new Author");
      bookArray[r].Author = roxy.next();
    }
    else
    {
      System.out.println("Please type new Publisher");
      bookArray[r].Publisher = roxy.next();
    }
    sortByName(1);
  }
  
  
  public Book [] decreaseArray(Book [] theArray)
  {
    int i = theArray.length;  
    int n = --i;  
    Book[] nArray = new Book[n];  
    for(int c=0;c<theArray.length-1;c++)
    {  
      nArray[c] = theArray[c];  
    }  
    return nArray;
  }
}