public class Node implements Comparable<Node> {

    int item;
    Node left, right;

    Node(int data){
        item=data;
        left=null;
        right=null;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}