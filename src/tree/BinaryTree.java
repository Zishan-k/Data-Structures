package tree;

import java.util.*;


class BinaryTree {
    //private static tree.Node root;
    Node root;

    private int max = 0;

    void findMaxElementFromBinaryTree(Node node) {

        if (node == null) {
            return;
        }

        if (node.item > max) {
            max = node.item;
        }
        findMaxElementFromBinaryTree(node.left);
        findMaxElementFromBinaryTree(node.right);
    }

    void preOrderTraversal(Node node) {
        if (node == null)
            return;

        System.out.print(node.item + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

    }

    void inorderTraversal(Node node) {

        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.item + " ");
        inorderTraversal(node.right);
    }

    void postOrderTraversal(Node node) {

        if (node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.item + " ");
    }

    void levelOrderTraversal() {

        Queue<Node> q = new PriorityQueue<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            System.out.print(poll.item + " ");
            //tree.Node right = poll.right;
            //tree.Node left = poll.left;

            if (poll.left != null) {
                q.add(poll.left);
            }
            if (poll.right != null) {
                q.add(poll.right);
            }

        }
    }

    void calculateSizeOfBinaryTree(Node root) {
        int i = 0;
        if (root == null) {
            return;
        }

        //System.out.print(root.item+ " ");
        i++;
        calculateSizeOfBinaryTree(root.left);
        calculateSizeOfBinaryTree(root.right);

    }


    void searchElement(Node node) {
        int data = 6, flag = 0;
        if (node == null) {
            return;
        }

        if (node.item == data) {
            System.out.println("Element is present in the tree.");
            flag = 1;
        }

        searchElement(node.left);

        searchElement(node.right);
        if (flag != 1)
            System.out.print("Element not found!");
    }


    void searchWithIteration(Node node, int data) {
        int flag = 0;

        Stack<Node> s = new Stack<Node>();
        s.push(node);

        while (!s.isEmpty()) {
            Node popped = s.peek();

            if (popped.item == data) {
                System.out.println("Element is present in the tree..");
                flag = 1;
            }
            //System.out.print(popped.item + " ");
            s.pop();

            if (popped.right != null)
                s.push(popped.right);
            if (popped.left != null)
                s.push(popped.left);

        }
        if (flag != 1)
            System.out.println("Element not found!");
    }


    void maxElementWithIteration(Node node) {
        Stack<Node> s = new Stack<Node>();
        s.push(node);
        int max1 = 0;
        while (!s.isEmpty()) {
            Node popped = s.peek();

            if (popped.item > max1) {
                max1 = popped.item;
            }
            //System.out.print(popped.item + " ");
            s.pop();

            if (popped.right != null)
                s.push(popped.right);
            if (popped.left != null)
                s.push(popped.left);

        }

        System.out.println("Max element is " + max1);
    }

    void preorderWithIteration(Node node) {
        //int flag=0;

        Stack<Node> s = new Stack<Node>();
        s.push(root);

        while (!s.isEmpty()) {
            Node popped = s.peek();
            System.out.print(popped.item + " ");
            s.pop();

            if (popped.right != null)
                s.push(popped.right);
            if (popped.left != null)
                s.push(popped.left);

            /*System.out.print(node.item+ " ");
            s.pop();

            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);*/

        }

    }

    void inorderWithIteration(Node node) {

        Stack<Node> s = new Stack<Node>();
        s.push(root);

        node = root;
        while (!s.isEmpty()) {

            if (node != null) {
                s.push(node);
                node = node.left;
            } else {

                if (s.isEmpty())
                    break;

                node = s.pop();
                System.out.print(node.item + " ");
                node = node.right;
            }
        }


    }


    void insertElement(Node node) {
        int data = 10;
        //tree.BinaryTree bt = new tree.BinaryTree();
        Stack<Node> s = new Stack<Node>();
        s.push(root);

        while (!s.isEmpty()) {
            Node popped = s.peek();
            //System.out.print(popped.item+ " ");
            s.pop();

            if (popped.right != null)
                s.push(popped.right);
            else {
                popped.right = new Node(data);
                break;
            }
            if (popped.left != null)
                s.push(popped.left);
            else {
                popped.left = new Node(data);
                break;
            }

        }
    }

    void spiralLevelOrderTraversal(Node node) {

        Queue<Node> q = new PriorityQueue<Node>();
        int flag = 0;
        q.add(root);
        while (!q.isEmpty()) {

            Node poll = q.poll();
            System.out.print(poll.item + " ");

            if (flag == 0) {
                flag = 1;

                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }

            } else {
                flag = 0;
                if (poll.right != null) {
                    q.add(poll.right);
                }
                if (poll.left != null) {
                    q.add(poll.left);
                }

            }
        }
    }


    void deleteAll() {
        root = null;
    }


    void reverseLevelOrder(Node node) {

        Queue<Node> q = new PriorityQueue<Node>();
        Stack<Integer> stack = new Stack<>();

        q.add(root);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            //  System.out.print(poll.item + " ");
            stack.push(poll.item);
            //tree.Node right = poll.right;
            //tree.Node left = poll.left;
            if (poll.left != null) {
                q.add(poll.left);
            }
            if (poll.right != null) {
                q.add(poll.right);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    void heightOfTree(Node node) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        queue.offer(null);
        int count = 0;
        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            if (curr != null) {
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }

            } else {
                count++;
                queue.offer(null);
            }

            if (queue.peek() == null && queue.size() == 1) {
                //return count;
                System.out.println("Break Occurred because only null remained in the queue!");
                break;
            }

        }
        System.out.println("Size of tree is " + count);
        //return count;
    }


    int minDeepestNode(Node node) {

        Queue<Node> q = new LinkedList<>();
        q.offer(null);
        q.offer(node);
        int count = 0;
        while (q.isEmpty() == false) {

            Node curr = q.poll();
            if (curr != null) {
                if (curr.left == null && curr.right == null)
                    return count;
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            } else {
                count++;
                q.offer(null);
            }
        }
        return count;
    }


    void deepestNode(Node node) {
        Node deepest = null;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            deepest = q.peek();
            Node curr = q.poll();

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
            //deepest= q.element();
        }


        if (deepest != null) {
            System.out.println("Deepest node is " + deepest.item);
        }
    }


    void numberOfLeafNodes(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(null);
        q.offer(node);
        int count = 0;
        while (!q.isEmpty()) {

            Node curr = q.poll();
            if (curr != null) {
                if (curr.left == null && curr.right == null)
                    count++;
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }

        }
        System.out.println("Number of leaf nodes are " + count);
    }


    void numberOfFullNodes(Node node) {
        Queue<Node> q = new LinkedList<>(); //LinkedList.LinkedList.java class is implementing Queue interface
        q.offer(node);
        int count = 0;
        while (!q.isEmpty()) {

            Node curr = q.poll();

            if (curr.left != null && curr.right != null) {
                count++;
            }

            if (curr.left != null)
                q.offer(curr.left);
            if (curr.right != null)
                q.offer(curr.right);
        }
        System.out.println("Number of full nodes are " + count);
    }

    void numberOfHalfNodes(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int count = 0;
        while (!q.isEmpty()) {

            Node curr = q.poll();

            if (curr.left == null && curr.right != null || curr.left != null && curr.right == null) {
                count++;
            }
            if (curr.left != null)
                q.offer(curr.left);
            if (curr.right != null)
                q.offer(curr.right);
        }

        System.out.println("Number of half nodes are " + count);
    }

    Stack<Integer> stack = new Stack<>();
    private void rootToLeafPath(Node root) {
        if (root == null) {
            return;
        }
        stack.push(root.item);
        if (root.left == null && root.right == null) {
            System.out.println(stack);
        }
        rootToLeafPath(root.left);
        rootToLeafPath(root.right);
        stack.pop();
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        bt.inorderTraversal(root);
        //bt.postOrderTraversal(bt.root);
        //bt.preOrderTraversal(bt.root);

        //Problem One(we can also do searching using the same algorithm)
        // bt.findMaxElementFromBinaryTree(bt.root);
        // System.out.println(bt.max);

        //Problem two(Maximum Element Without Recursion)
        //bt.maxElementWithIteration(bt.root);


        //Problem Three
        //bt.searchElement(bt.root);


        //Problem Four(Search without recursion)
        //int data=5;
        //bt.searchWithIteration(bt.root, data);


        //Level Order Traversal
        //bt.levelOrderTraversal();

        //Calculate Size Of tree.BinaryTree
        //bt.calculateSizeOfBinaryTree(bt.root);
        //System.out.println("size:"+bt.i);

        //bt.preorderWithIteration(bt.root);

        //Insert an element
        //bt.insertElement(bt.root);

        //bt.spiralLevelOrderTraversal(bt.root);

        //delete all elements
        //bt.deleteAll();
        //bt.reverseLevelOrder(bt.root);

        //bt.inorderWithIteration(bt.root);

        //bt.levelOrderTraversal();

        //bt.heightOfTree(bt.root);

        //Minimum Deepest tree.Node
        //System.out.println("Minimum deepest node is :" + bt.minDeepestNode(bt.root));

        //bt.heightOfTree(bt.root);
        //bt.rootToLeafPath(bt.root);

        //bt.deepestNode(bt.root);
        //bt.numberOfLeafNodes(bt.root);
        //bt.numberOfFullNodes(bt.root);

        //bt.numberOfHalfNodes(bt.root);
        //bt.numberOfHalfNodes(bt.root);
    }
}


