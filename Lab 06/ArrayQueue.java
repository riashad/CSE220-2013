public class ArrayQueue implements Queue {
  
  private static final int DEFAULT_INITIAL_CAPACITY = 10;
  
  private Object[]         data;
  
  private int              front;
  
  private int              size;
  
  public ArrayQueue(int initialCapacity) {
    data = new Object[initialCapacity];
    size=0;
    front = 0;
  }
  
  public ArrayQueue() {
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
  
  public void enqueue(Object item) {
    if(size==data.length){
      int newCapacity= data.length*2/3;
      Object []oldData= data;
      data= new Object[newCapacity];
      int k = front;
      for(int i =0;i<size;i++){
        data[i] = oldData[k];
        k = (k+1)% oldData.length;
      }
      front = 0;
    }
    int newPosition = (size+front) % data.length;
    data[newPosition] = item;
    size++;
    
  }
  
  public Object dequeue() throws Exception {
    if(size==0){
      throw new Exception("The Array Queue is empty.");
    }
    else{
      Object k = data[front];
      data[front]=null;
      front = (front + 1)% data.length;
      size--;
      return k;
    }
  }
  
  public Object peek() throws Exception {
    if(size==0){
      throw new Exception("The Array Queue is empty.");
    }
    else{
      Object k = data[front];
      return k;
    }
  }
  
  public int search(MyNode item) {
    int frontElement = front;
    
    for(int i = 0;  i < size; i++){
      MyNode n = (MyNode)data[frontElement];
      
      if((n.element).equals(item.element)){
    
        return i;
      }
    
      frontElement = (frontElement + 1)%data.length;
    }
    return -1;
  }
  
  
  
  public Object[] toArray() {
    
    Object []output =  new Object[size];
    int k = front;
    for(int i = 0;i<size;i++){
      output[i]= data[k];
      k = (k+1)% data.length;
    }
    return output;
  }
  
  public boolean equals(Object o) {
    
    if (this == o)
      return true;
    if (o == null || !(o instanceof Queue))
      return false;
    
    Queue otherQueue = (Queue) o;
    if (otherQueue.size() != size)
      return false;
    
    Object[] otherElements = otherQueue.toArray();
    
    int i = this.front;
    for (int k = 0; k < this.size; k++) {
      if (!this.data[i].equals(otherElements[k]))
        return false;
      i = (i + 1) % this.data.length;
    }
    return true;
  }
  
  public String toString() {
    String s = "[";
    int k = front;
    for(int i = 0;i<size;i++){
      s = s + " " + data[k];
      k = (k+1)% data.length;
    }
    s= s + " ]";
    
    return s;
  }
  
}