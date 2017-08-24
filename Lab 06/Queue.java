public interface Queue {
  int size();
  boolean isEmpty();
  void enqueue(Object item) throws Exception;
  Object dequeue() throws Exception;
  Object peek() throws Exception;
  int search(MyNode item);
  Object[] toArray();
}
