class ListNode {
    public ListNode prev = null;
    ListNode next;
    int data;

    public ListNode(int data,ListNode next) {
        this.next = next;
        this.data = data;
    }
}
public class LinkedList {

    void insert(ListNode head, int data) {
        ListNode listNode1 = head;
        while (listNode1.next != null) {
            listNode1 = listNode1.next;
        }
        listNode1.next = new ListNode(data, null);
    }


    void print(ListNode listNode) {
        if (listNode == null) {
            return;
        }

        System.out.print(listNode.data);
        print(listNode.next);
    }

    ListNode listNode;
    void reverse(ListNode head) {

       ListNode current = head;
       ListNode prev = null;
       ListNode next = current.next;

       while (next != null){
           current.next = prev;
           prev = current;
           current = next;
           next = next.next;
           }
       current.next = prev;


        print(current);
    }

    void pairReverse(ListNode head){
        ListNode current = head.next;
        ListNode prev = head;
        ListNode next = current.next;

            /*current.next = next.next;
            next.next = current;*/
            while(current.next != null) {

                current.data = current.next.data;
                current.next.data = current.data;
                current = current.next.next;


                /*current.next = prev;
                prev.next = next;
                current = prev.next;
                next = current.next;*/

            }


        print(current);
    }

    void checkEvenOdd(ListNode n){
        while (n != null && n.next != null) {
            n = n.next.next;
        }
        if (n == null){
            System.out.println("List is even");
        }
        else
            System.out.println("List is odd");
    }

    ListNode head;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode head = new ListNode(1, null);
        list.insert(head, 2);
        list.insert(head, 3);
        list.insert(head, 4);
       /* list.insert(head, 5);
        list.insert(head, 6);*/
//        list.insert(head, 7);
//        list.print(head);
//        list.head = head;
//        list.reverse(head);
//        list.print(head);
//        list.checkEvenOdd(head);


//        list.reverse(head);
//        list.print(head);

        list.pairReverse(head);
    }

}