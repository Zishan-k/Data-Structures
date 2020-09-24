public class LinkedList {

    static ListNode head;

    void insert(ListNode node, int data) {
        if(node == null)
            head= new ListNode(data);
        else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(data);
        }
    }

    void printList(ListNode listNode) {
        if(listNode == null)
            System.out.println("No element");
        else {
            System.out.println("Linked List:");
            while (listNode != null) {
                System.out.print(listNode.data + " ");
                listNode = listNode.next;
            }
        }
    }

    void printNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        System.out.print(listNode.data);
        printNode(listNode.next);
    }

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


        printNode(current);
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
        printNode(current);
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

    void deleteLinkedList(){
        head= null;
    }

    void getMiddleNode(ListNode n){
        ListNode fastPointer= n, slowPointer= n;
        while (fastPointer != null && fastPointer.next != null){
            slowPointer= slowPointer.next;
            fastPointer= fastPointer.next.next;
        }
        System.out.println("Middle Element of Linked List: "+ slowPointer.data);
    }

    //1->2->3->4
    void reverseLinkedList(ListNode head){
        ListNode prev= null, curr= head, next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        printList(prev);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(head,1);
        list.insert(head,2);
        list.insert(head,3);
        list.insert(head,4);
        list.insert(head,5);
       /* list.insert(head, 5);
        list.insert(head, 6);*/
        //list.insert(head, 7);
        //list.print(head);
        //list.head = head;
        //list.reverse(head);
        //list.print(head);
        //list.checkEvenOdd(head);
        //list.reverse(head);
        //list.print(head);
        //list.getMiddleNode(head);
        //list.deleteLinkedList();
        //list.pairReverse(list.head);
        //list.printList();
        list.reverseLinkedList(head);
        //list.printList(head);
    }
}