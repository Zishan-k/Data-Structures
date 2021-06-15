package LinkedList;



import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MyLinkedList {

    static ListNodeMain head;
    static void insert(ListNodeMain node, int data) {
        if (node == null)
            head = new ListNodeMain(data);
        else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNodeMain(data);
        }
    }

    void printList(ListNodeMain listNodeMain) {
        if (listNodeMain == null)
            System.out.println("No element");
        else {
            System.out.println("Linked List:");
            while (listNodeMain != null) {
                System.out.print(listNodeMain.data + " ");
                listNodeMain = listNodeMain.next;
            }
        }
    }

    void printNode(ListNodeMain listNodeMain) {
        if (listNodeMain == null) {
            return;
        }
        System.out.print(listNodeMain.data);
        printNode(listNodeMain.next);
    }

    void reverse(ListNodeMain head) {

        ListNodeMain current = head;
        ListNodeMain prev = null;
        ListNodeMain next = current.next;

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;


        printNode(current);
    }

    void pairReverse(ListNodeMain head) {
        ListNodeMain current = head.next;
        ListNodeMain prev = head;
        ListNodeMain next = current.next;

            /*current.next = next.next;
            next.next = current;*/
        while (current.next != null) {

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

    void checkEvenOdd(ListNodeMain n) {
        while (n != null && n.next != null) {
            n = n.next.next;
        }
        if (n == null) {
            System.out.println("List is even");
        } else
            System.out.println("List is odd");
    }

    void deleteLinkedList() {
        head = null;
    }

    void getMiddleNode(ListNodeMain n) {
        ListNodeMain fastPointer = n, slowPointer = n;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        System.out.println("Middle Element of Linked List: " + slowPointer.data);
    }

    //1->2->3->4
    void reverseLinkedList(ListNodeMain head) {
        ListNodeMain prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        printList(prev);
    }


    int getNthFromLast(ListNodeMain head, int n) {
        // Your code here
        ListNodeMain start = head;
        int count = 0;
        while (start != null) {
            count++;
            start = start.next;
        }
        if (n > count)
            return -1;
        else if (n == count)
            return head.data;
        else {
            start = head;
            for (int i = 1; i <= count - n; i++) {
                start = start.next;
            }
            return start.data;
        }
    }

    public static void main(String[] args) {
        insert(head, 1);
        insert(head, 2);
        insert(head, 3);
        insert(head, 4);
        insert(head, 5);
        insert(head, 6);
        insert(head, 7);
        insert(head, 8);
        insert(head, 9);
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
        //list.reverseLinkedList(head);
        //list.printList(head);
        //System.out.println(list.getNthFromLast(head, 2));
    }
}