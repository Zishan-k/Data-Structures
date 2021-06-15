package LinkedList;

public class MyLinkedListMain {
    int data;
    public MyLinkedListMain next;

    public MyLinkedListMain() {
    }

    public MyLinkedListMain(int data) {
        this.data = data;
    }

    public void insert(MyLinkedListMain head, int data) {
        if (head == null) {
            head = new MyLinkedListMain(data);
        } else {
            MyLinkedListMain temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = new MyLinkedListMain(data);
        }
    }

    public void printList(MyLinkedListMain head) {
        MyLinkedListMain temp = head;
        if (temp == null) System.out.println("Empty!!");
        else {
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
        }
    }
    public void remove(MyLinkedListMain head, int position, int i){
        if(head == null) return;
        if(i == position - 1){
            head = head.next;
            return;
        }
        remove(head.next, position, i+1);
    }
}
