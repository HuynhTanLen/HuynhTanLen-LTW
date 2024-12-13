package Collection;

public class Link <T extends Comparable<T>>{
    T data;
    Link<T> next;
    Link<T> previous;
    public Link(T d){
        this.data=d;
    }


}
