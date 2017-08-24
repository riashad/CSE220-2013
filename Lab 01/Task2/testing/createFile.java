import java.io.*;
import java.lang.*;
import java.util.*;

public class createFile{
  private Formatter x;
  
  public void openFile(){
    try{
      x = new Formatter ("E:\\output_file.txt");
    }
    catch (Exception e){
      System.out.println ("You have an error!");
    }
  }
  
  public void addRecords(String a, int b, String c, String d){
    x.format("%s %s %s %s %s",a,b,c,d,"\r\n");
  }
  public void closeFile(){
    x.close();
  }
}