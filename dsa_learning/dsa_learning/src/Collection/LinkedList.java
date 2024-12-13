package Collection;

public class LinkedList <T extends Comparable<T>>{
    private Link<T> first;
    private Link<T> last;
    private Link<T> pos;
    private int size;
    public LinkedList(){}
    public boolean isEmpty(){
        return first == null;
    }
    private void add(T item,Link p){
        Link<T> newLink,q;
        newLink = new Link<>(item);
        q=(p==null)?first:p.next;
        newLink.next=q;
       if(p == null){
           first=newLink;
       }
       else
           p.next=newLink;
       newLink.previous=p;
       if(q==null)
           last=newLink;
       else
           q.previous=newLink;
        size++;
    }
    private void remove(Link p){
        if (p == null && first == null) {
            // Trường hợp danh sách rỗng
            System.out.println("Cannot remove: List is empty.");
            return;
        }

        // Xác định nút cần xóa
        Link<T> t = (p == null ? first : p.next);

        if (t == null) {
            // Không có phần tử nào để xóa
            System.out.println("Cannot remove: Target link does not exist.");
            return;
        }

        // Xác định nút tiếp theo
        Link<T> q = t.next;

        // Cập nhật liên kết
        if (p == null) {
            first = q; // Xóa phần tử đầu
        } else {
            p.next = q; // Bỏ qua nút `t`
        }

        if (q == null) {
            last = p; // Xóa phần tử cuối
        } else {
            q.previous = p; // Kết nối ngược lại
        }

        size--; // Giảm kích thước
    }
    public void addFirst(T data){
        add(data,null);
    }
    public void addLast(T data){
        add(data,last);
    }
    public void addPos(T data){
        add(data,pos);
    }
    public void removeFirst(){
        remove(null);
    }
    public void removeLast(){
        remove(last);
    }
    public void removePos(){
        remove(pos);
    }
    public void startFirst(){
        pos=first;
    }
    public void startEnd(){
        pos=last;
    }
    public void next(){
        if(pos!=null)
            pos=pos.next;
        else pos=last;
    }
    public void previous(){
        if(pos!=null)
            pos=pos.previous;
        else pos=first;
    }
    public T get(){
        return pos.data;
    }
    public int size(){
        return size;
    }
    public boolean endList(){
        return pos==null;
    }
    public boolean searchList(T data){
        Link<T> cur=first;
        pos=null;
        while(cur!=null&&!pos.data.equals(data)){
            pos=cur;
            cur=cur.next;
        }
        return cur!=null;
    }
    public boolean searchOrderList(T data) {
        Link<T> cur = first;
        pos = null;
        while (cur != null && cur.data != null && cur.data.compareTo(data) < 0) {
            pos = cur;
            cur = cur.next;
        }
        return cur != null;
    }
    public int com(T data){
        return first.data.compareTo(data);
    }
}
