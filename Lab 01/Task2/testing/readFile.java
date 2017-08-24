import java.io.*;
import java.util.*;

public class readFile{
  private Scanner y;
  public void openFile(){
    try{
      y= new Scanner(new File("E:\\input_file.txt"));
    }
    catch(Exception e){
      System.out.println("Could not find file!");
    } 
  }
  
  public void readFile(){
    createFile g=new createFile();
    
    BookRecord data = new BookRecord();
    data.bookArray= new Book [1];
    int c=0;  g.openFile();
    while(y.hasNext()){
      data.bookArray[c] = new Book();
      data.bookArray[c].Name=y.next();
      data.bookArray[c].Id=y.nextInt();
      data.bookArray[c].Author=y.next();
      data.bookArray[c].Publisher=y.next();
      data.bookArray = data.increaseArray(data.bookArray);
    
      g.addRecords(data.bookArray[c].Name,data.bookArray[c].Id,data.bookArray[c].Author,data.bookArray[c].Publisher);
     
      c++;
    } g.closeFile();
  }
  
  public void closeFile(){
    y.close();
  }
}