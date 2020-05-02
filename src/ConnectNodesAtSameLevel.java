import java.util.*;
import java.util.LinkedList;

public class ConnectNodesAtSameLevel {
    Node root;

    void connect(Node p) {
        // initialize queue to hold nodes at same level
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        queue.offer(null);

        Node temp = null; // initializing prev to null
        while (!queue.isEmpty()) {
            queue.offer(root);
            queue.offer(null);
            int count = -1;

            while (!queue.isEmpty()) {

                Node poll = queue.poll();

                if (queue.peek() == null && queue.size() == 1) {
                    break;
                }

                if (poll != null) {
                    System.out.print(poll.item + " ");
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                } else {
                    poll.nextRight = null;
                }
            }
        }
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();

        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);

        // Populates nextRight pointer in all nodes
        tree.connect(tree.root);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in "
                + "the tree"
                + "(-1 is printed if there is no nextRight)");
        int a = tree.root.nextRight != null ? tree.root.nextRight.item : -1;
        System.out.println("nextRight of " + tree.root.item + " is "
                + a);
        int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.item : -1;
        System.out.println("nextRight of " + tree.root.left.item + " is "
                + b);
        int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.item : -1;
        System.out.println("nextRight of " + tree.root.right.item + " is "
                + c);
        int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.item : -1;
        System.out.println("nextRight of " + tree.root.left.left.item + " is "
                + d);
    }
}