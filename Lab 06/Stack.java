public interface Stack {
  int size();
  boolean isEmpty();
  void push(Object item) throws Exception;
  Object pop() throws Exception;
  Object peek() throws Exception;
  void clear();
  int search(Object item);
  Object[] toArray();
}
