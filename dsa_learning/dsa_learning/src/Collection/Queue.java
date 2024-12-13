package Collection;

public class Queue <T extends Comparable<T>>{
    private LinkedList<T> list;
    public Queue(){
        list = new LinkedList<>();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void enqueue(T data){
        list.addLast(data);
    }
    public T dequeue(){
        list.startFirst();
        T temp = list.get();
        list.removeFirst();
        return temp;
    }
    public T peek(){
        list.startFirst();
        return list.get();
    }
}
