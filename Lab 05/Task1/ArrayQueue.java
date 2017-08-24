public class ArrayQueue{
  public int size;
  private Patient data[];
  
// ____________________________________________________________
  public ArrayQueue(){
    data = new Patient[10];
    size = 0;
  }
  
// ____________________________________________________________
  public int size(){
    return size;
  }
  
// ____________________________________________________________
  public void RegisterPatient(String s,int id){
    Patient p = new Patient(s,id);
    System.out.println("Registration of Patient Id: "+id+" and Name: "+s+" is in progress. Please wait for a while!");
    if(size==data.length){
      Patient oldData[] = data;
      data = new Patient[data.length*2];
      for(int i=0;i<size;i++){
        data[i] = oldData[i];
      }
    }
    data[size] = p;
    size++;
    System.out.println("The Patient has been regestered");
    System.out.println("***************************************");
  }
  
  // ____________________________________________________________
  public Object ServePatient() throws QueueException{
    if(size==0){
      throw new QueueException("There is no Patient to serve.");
    }
    Object patient = (Object)data[0];
    for(int i=0;i<size-1;i++){
      data[i] = data[i+1];
    }
    data[size-1]=null;
    size--;
    return patient;
  }  
  
  // ____________________________________________________________
  public String CancelAll(){
    if(size==0) 
      return "There is no Appointment to cancel!";
    else{
      for(int i=0;i<size;i++){
        data[i] = null;
      }
      size = 0;
    }
    return "All appointments have been cancelled.";
  }
// ____________________________________________________________
  public boolean CanDoctorGoHome(){
    if(size==0)
      return true;
    else
      return false;
  }
  
  // ____________________________________________________________
  
  
  public Patient[] toArray(){
    Patient a [] = new Patient[size];
    for(int i=0;i<size;i++){
      a[i] = data[i];
    }
    return a;
  }
  // ____________________________________________________________
  
  public void ShowAllPatient(){
    if(size==0){
      System.out.println("No Patient.");
      return;
    }
    Patient temp[]= toArray();
    for(int i=0; i<temp.length;i++){//sorting
      for(int f=i+1;f<temp.length;f++){
        if((temp[i].name.compareTo(temp[f].name))>0){
          Patient tmp=temp[i];
          temp[i]=temp[f];
          temp[f]=tmp;
        }
      }
    }
    for(int i=0;i<size;i++){
      System.out.println(temp[i]);
    }
  }
  
}
