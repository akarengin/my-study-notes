package hackerrank;

import java.util.Scanner;

public class QHEAP1 {

    private Node root;

    public class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node curr;
            if (data < root.data) {
                curr = insert(root.left, data);
                root.left = curr;
            } else {
                curr = insert(root.right, data);
                root.right = curr;
            }
        }
        return root;
    }

    public Node deleteNode (Node root, int data) {
        if (root == null) {
            return null;
        } else if (root.data == data) {
            return root;
        } else if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else {
            root.right = deleteNode(root.right, data);
        }
        return root;
    }

    public void printMinimum (Node root) {
        if (root.left != null) {
            printMinimum(root.left);
        }
        System.out.println(root.data);
    }

    public void qHeap1(int query, int number) {
        if(query == 1) {
            root = insert(root, number);
        } else if (query == 2) {
            root = deleteNode(root, number);
        } else if (query == 3) {
            printMinimum(root);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        QHEAP1 qh = new QHEAP1();
        for (int i = 0; i < n; i++) {
            int a, b;
            a = scanner.nextInt(); b = scanner.nextInt();
            qh.qHeap1(a, b);
        }
        scanner.close();
    }
}
