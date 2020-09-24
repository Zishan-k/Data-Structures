package tree;

public class Node {

    int item;
    Node left, right, nextRight;

    Node(int data) {
        item = data;
        left = right = nextRight = null;
    }
}