import java.util.*;
public class Tester{
  
  public static void main(String args[]){
    Scanner roxy = new Scanner(System.in);
    ListQueue a = new ListQueue();
    int count = 1;
    while(true){
      System.out.println ("Enter Please: 0 to Quit");
      System.out.println ("Enter Please: 1 to Add a Patient");
      System.out.println ("Enter Please: 2 to serve a Patient");
      System.out.println ("Enter Please: 3 to Cancel All");
      System.out.println ("Enter Please: 4 to see if Doctor can go home");
      System.out.println("Enter Please: 5 to show All Patients");
      int input = roxy.nextInt();
      if(input==0){
        System.out.println("Thank you!");
        break;
      }else if(input==1){
        System.out.println("Please Enter a Patient's Name...");
        String s = inputName();
        a.RegisterPatient(s,count);
        count++;
      }else if(input==2){
        try{
          System.out.println("Now Serving Patient ID and Name : "+ a.ServePatient());
        }catch(Exception e){
          System.out.println(e);
        }
        System.out.println("*******************************************");
      }else if(input==3){
        a.CancelAll();
        System.out.println("*******************************************");
      }else if(input==4){
        if(a.CanDoctorGoHome()==true){
          System.out.println("Yes!The doctor can go home!");
          System.out.println("*******************************************");
        }
        else{
          System.out.println("Sorry, the doctor can't go home now.");
          System.out.println("*******************************************");
        }
      }else if(input==5){
        if(a.size()==0){
          System.out.println("There are no patients!");
          System.out.println("*******************************************");
        }
        else{
          a.ShowAllPatient();
          System.out.println("*******************************************");
        }
      }
    }
  }
  public static String inputName(){
    Scanner rox = new Scanner(System.in);
    String s = rox.nextLine();
    return s;
  }
}