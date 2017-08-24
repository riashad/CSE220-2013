public class CircularQueue{
  public int size;
  public int front;
  public Patient[]data;
  
//________________________________________________________________ 
  public CircularQueue(){
    data=new Patient[10];
    size=0;
    front=0;
  }
  
//________________________________________________________________
  public int size(){
    return size;
  }
  
  
//________________________________________________________________
  public void RegisterPatient(String name, int id){ 
    Patient p=new Patient(name,id);
    System.out.println("Registering the Patient with Name : "+ name+" and ID : "+id+"...");
    resize();
    int i=(front+size)%data.length;
    data[i]=p;
    size++; 
    System.out.println("Patient has been registered!");
    System.out.println("******************************************");
  }
  
//________________________________________________________________
  public void resize(){
    if(size==data.length){
      Patient[]data1=data;
      data=new Patient[2*data1.length];
      int index=front;
      for(int i=0;i<size;i++){
        data1[i]=data[index];
        index=(index+1)%data.length;
      }
    }
  }
  
  
//________________________________________________________________ 
  public Object ServePatient() throws QueueException{
    if(size==0){
      throw new QueueException("No Patient!");
    }
    Object p = (Object)data[front];
    for(int i=front;i<size;i =(i+1)%data.length){
      data[i]=data[i+1];
    }
    size--;
    front=0;
    return p;
  }
  
//________________________________________________________________
  public void  CancelAll(){ 
    int i=0;
    while(i<size){
      data[i]=null;
      i=(i+1)%data.length;
    }
    size=0;
  }
  
  
//________________________________________________________________
  public boolean CanDoctorGoHome(){
    if(size==0){
      return true;
    }else{
      return false;
    }
  }
//________________________________________________________________
  
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
//________________________________________________________________  
  public Patient[] toArray() {
    Patient [] a=new Patient[size];
    int index=front;
    for(int i=0;i<size;i++){
      a[i]=data[index];
      index=(index+1)%data.length;
    }
    front=0;
    return a;
  }
  
  

}
