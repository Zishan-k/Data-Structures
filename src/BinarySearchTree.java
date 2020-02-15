import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class BinarySearchTree {

    private Node root;

    void insertElement(Node root, int data){
        //System.out.println("Insert method called");
            Stack<Node> s= new Stack<>();
            s.push(root);

            while(!s.isEmpty()){
                Node popped =s.peek();
                s.pop();

                if(popped.item > data) {
                    if (popped.left != null) {
                        s.push(popped.left);
                    }
                    else{
                        popped.left= new Node(data);
                    }
                }
                else if(popped.item < data) {
                    if (popped.right != null) {
                        s.push(popped.right);
                    }
                    else{
                        popped.right= new Node(data);
                    }
                }
            }
            //System.out.println("Data added!");
        }


        void findLCA(Node node, int a, int b){

            Node n1 = node;
            Node n2 = node;
            int lastVisitedNode= 0;
            ArrayList<Integer> visitedNode= new ArrayList<>();


            while (n1 != null && n1.item != a){

                if(a > n1.item){
                    visitedNode.add(n1.item);
                    n1= n1.right;
                }
                else{
                    visitedNode.add(n1.item);
                    n1= n1.left;
                }
            }

            while(n2 != null && n2.item != b){

                if(b > n2.item){

                    if(visitedNode.contains(n2.item)){
                        lastVisitedNode= n2.item;
                    }
                    n2=n2.right;
                }
                else{

                    if(visitedNode.contains(n2.item)){
                        lastVisitedNode= n2.item;
                    }
                    n2= n2.left;
                }

            }
            System.out.println(lastVisitedNode + " is the LCA");
        }


        void checkBST(Node root){
            int flag=0;
            Stack<Node> s= new Stack<Node>();
            s.push(root);

            while (!s.isEmpty()) {
                Node node= s.pop();
                if (node == null) {
                    System.out.println("Not BST!");
                    flag=1;
                    break;
                }
                if (node.left != null && node.left.item < node.item) {
                    s.push(node.left);
                }
                else {
                    System.out.println("Not BST!");
                    flag=1;
                    break;
                }
                if (node.right != null && node.right.item > node.item) {
                    s.push(node.right);
                }

            }
            if (flag == 0) {
                System.out.println("Is is BST");
            }
    }

    void rangeBST(Node root, int a, int b){
        Node node;
        Queue<Node> q= new PriorityQueue<>();
        q.offer(root);

        while (!q.isEmpty()) {
            node=q.poll();
            if (node.item >= a && node.item <= b) {
                System.out.print(" "+node.item);

            }
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
        System.out.println();
    }
        void display(Node root){
            System.out.println("PreOrder:");

            Stack<Node> s= new Stack<>();
            s.push(root);

            while(!s.isEmpty()){

                Node popped= s.pop();
                System.out.print(popped.item+" ");
//                s.pop();

                if(popped.left != null){
                    s.push(popped.left);
                }
                if(popped.right != null){
                    s.push(popped.right);
                }
            }
        }

    public static void main(String[] args) {
            BinarySearchTree bst=new BinarySearchTree();
            bst.root= new Node(10);
            bst.insertElement(bst.root, 12);
            bst.insertElement(bst.root, 8);
            bst.insertElement(bst.root, 2);
            bst.insertElement(bst.root, 9);
            bst.insertElement(bst.root, 15);


           // bst.rangeBST(bst.root, 10,20);
            bst.findLCA(bst.root,2,9);
            bst.findLCA(bst.root,2,12);
            bst.findLCA(bst.root,9,12);
//            bst.checkBST(bst.root);
            bst.display(bst.root);
    }
}
