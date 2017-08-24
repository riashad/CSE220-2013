public class ArrayStack implements Stack {
  
  private static final int DEFAULT_INITIAL_CAPACITY = 10;
  
  private Object[]         data;
  
  private int              size;
  
  public ArrayStack(int initialCapacity) {
    data = new Object[initialCapacity];
  }
  
  public ArrayStack() {
    this(DEFAULT_INITIAL_CAPACITY);
  }
  
  public int size() {
    return size;   
  }
  
  public boolean isEmpty() {
    if(size==0){
      return true;
    }
    else{
      return false;
    }
  }
  
  public void ensureCapacity(int minCapacity) {
    if(data.length >= minCapacity){
      return;
    }
    int newCapacity= data.length*2/3;
    if(newCapacity<minCapacity){
      newCapacity=minCapacity;
    }
    Object []oldData= data;
    data= new Object[newCapacity];
    for(int i=0;i<size;i++){
      data[i]=oldData[i];
    }
  }
  
  public void push(Object item) {
    
    ensureCapacity(size+1);
    data[size]= item;
    size++;
  }
  
  
  public Object pop() throws Exception {
    
    if(size==0){
      throw new Exception("The Array Stack is empty.");
    }
    else{
      Object c = data[size - 1];
      data[size-1] = null;
      size--;
      return c;
      
    }
  }
  
  public Object peek() throws Exception {
    
    if(size==0){
      throw new Exception("The Array Stack is empty.");
    }
    else{
      Object c = data[size-1];
      return c;
    }
  }
  
  public void clear() {
    for(int i=0;i<size;i++){
      data[i]=null;
    }
    size=0;
  }
  
  public int search(Object item) {
    
    int c = size-1;
    for(int i = c;i>=0;i--){
      if(data[i]==item){
        return (c-i);
      }
    }
    return -1;
  }
  
  
  public Object[] toArray() {
    
    Object []output = new Object[size];
    int c = size - 1;
    for(int i = 0;i<size;i++){
      output[i] = data[c];
      c--;
    }
    return output;
  }
  
  
  public boolean equals(Object o) {
    
    if (this == o)
      return true;
    
    if (o == null || !(o instanceof Stack))
      return false;
    
    Stack otherStack = (Stack) o;
    if (otherStack.size() != size)
      return false;
    
    Object [] thisArray = toArray();
    Object [] otherStackArray = otherStack.toArray();
    for(int i =0;i<size;i++){
      if(!(thisArray[i].equals(otherStackArray[i]))){
        return false;
      }
    }
    return true;
    
    
  }
  
  
  public String toString() {
    String s = "[";
    for(int i= size-1;i>=0;i--){
      s = s + " " + data[i];
    }
    s = s + " ]";
    return s;
  }
  
}