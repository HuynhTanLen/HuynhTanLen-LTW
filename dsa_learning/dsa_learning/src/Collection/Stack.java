package Collection;

public class Stack <T extends Comparable<T>>{
    private Link<T> top;
    private int size;
    public boolean isEmpty(){
        return top==null;
    }
    public void push(T item){
        Link<T> newLink=new Link<>(item);
        newLink.next=top;
        top=newLink;
        size++;
    }
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        T popped=top.data;
        top=top.next;
        size--;
        return popped;
    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }
    public int size(){
        return size;
    }

}
