package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree1 {
    Node root;

    boolean checkIdentical(Node node1, Node node2){
        Stack<Node> s= new Stack<Node>();
        Stack<Node> s1= new Stack<Node>();

        s.push(node1);
        s1.push(node2);

        Queue<Node> q1= new LinkedList<>();
        Queue<Node> q2= new LinkedList<>();

        q1.offer(node1);
        q2.offer(node2);

        while(!s.isEmpty()){
            Node curr= s.peek();
            System.out.print(curr.item+" ");
            q1.offer(curr);
            s.pop();

            if (curr.right != null)
                s.push(curr.right);
            if (curr.left != null)
                s.push(curr.left);
        }

        while(!s1.isEmpty()){
            Node curr= s1.peek();
            System.out.print(curr.item+" ");
            q2.offer(curr);
            s1.pop();

            if (curr.right != null)
                s1.push(curr.right);
            if (curr.left != null)
                s1.push(curr.left);
        }

        while(!q1.isEmpty() && !q2.isEmpty()){
            Node n1=q1.poll();
            Node n2=q2.poll();

            if(n1.item != n2.item)
                return false;
        }
    return true;
    }


    public static void main(String[] args) {
        BinaryTree1 bt1=new BinaryTree1();
        BinaryTree1 bt2=new BinaryTree1();

        bt1.root = new Node(1);
        bt1.root.left = new Node(2);
        bt1.root.right = new Node(3);
        bt1.root.left.left = new Node(4);
        bt1.root.right.right = new Node(8);


        bt2.root = new Node(1);
        bt2.root.left = new Node(2);
        bt2.root.right = new Node(3);
        bt2.root.left.left = new Node(4);
        bt2.root.right.right = new Node(5);

        if(bt1.checkIdentical(bt1.root, bt2.root)){
            System.out.println("Both trees are identical");
        }
        else
            System.out.println("Both trees are not identical");

    }
}
