public class BookRecord{
  Book [] bookArray;
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
}