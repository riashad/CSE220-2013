public class Patient {
  String name;
  int id;
  Patient(String n, int i){
    name=n;
    id = i;
  }
  public String toString(){
    return id+":"+name;
  }
}