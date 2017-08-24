public class  TreeElement  {
  public  int element;
  public TreeElement left;
  public TreeElement right;
  
  TreeElement (int  e){
    element=e;
    left=null;
    right=null;
  }
  
  TreeElement (int  e,TreeElement l,TreeElement r){
    element=e;
    left=l;
    right=r;
  }
  public String toString(){
    return "Element : "+element+" ";
  }
}