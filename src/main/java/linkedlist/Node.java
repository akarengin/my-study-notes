package linkedlist;

import java.util.LinkedList;
import java.util.List;

import hackerrank.DoublyLinkedListNode;
import hackerrank.SinglyLinkedListNode;
import problems.InterviewQuestions;

public class Node {
    public Node left;
    public Node right;
    public int data;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node addToEnd(Node head, int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node curr = head;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = n;
            n.left = curr;
        }
        return head;
    }

    public static Node addToStart(Node head, int data) {
        Node n = new Node(data);
        if (head != null) {
            n.right = head;
            head.left = n;
        }
        head = n;
        return head;
    }

    public static Node addToAfter(Node head, int insertAfter, int data) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null && curr.data != insertAfter) {
            curr = curr.right;
        }
        if (curr == null) {
            // insertAfter value not found
            return null;
        }
        Node n = new Node(data);
        n.right = curr.right;
        if (curr.right != null) {
            curr.right.left = n;
        }
        curr.right = n;
        n.left = curr;
        return head;
    }

    // Recursive call ---- WRONG !!!
    public static Node addToAFTER(Node head, int insertAfter, int data) {
        Node curr = head;
        if(curr == null) return null;
        if(curr.data == insertAfter) {
            Node n = new Node(data);
            n.right = curr.right;
            if(curr.right != null) {
                curr.right.left = n;
            }
            curr.right = n;
            n.left = curr;
            return head;
        }
        return addToAFTER(curr.right, insertAfter, data);
    }


    public static Node deleteLast(Node head) {
        if (head == null || head.right == null) {
            return null;
        }
        Node toDelete = head;
        while (toDelete.right != null) {
            toDelete = toDelete.right;
        }
        toDelete.left.right = null;
        return head;
    }

    public static Node deleteFirst(Node head) {
        if (head == null || head.right == null) {
            return null;
        }
        head = head.right;
        head.left = null;
        return head;
    }

    private static Node deleteNodeAfter(Node head, int deleteAfter) {
        if (head == null) return null;
        Node curr = head;
        while (curr.right != null && curr.data != deleteAfter) {
            curr = curr.right;
        }
        if (curr == null) return null;
        if (curr.right != null) {
            curr.right = null;
        }
        return head;
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode head = llist;
        if (head == null) return null;
        SinglyLinkedListNode curr = head;
        int idx = 1;
        while (curr != null && idx != position) {
            curr = curr.next;
            idx++;
        }
        if(curr == null) return null;
        SinglyLinkedListNode n = new SinglyLinkedListNode(data);
        if (curr.next != null) {
            n.next = curr.next;
        }
        curr.next = n;
        return head;
    }

    // Write a method which print the tree's preorder traversal as a single line of space-separated values.
    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Write a method which print the tree's inOrder traversal as a single line of space-separated values.
    public static void inOrder(Node root) {
        int count = 0;
        if(root == null) {
            return;
        }
        count++;  // It can be replaced by the following line, it doesn't matter!
        inOrder(root.left);
        if(count == 1) System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        int count = 0;
        if(root == null) {
            return;
        }
        count++;
        postOrder(root.left);
        count++;
        postOrder(root.right);
        if(count == 2) System.out.print(root.data + " ");
    }

    // Write a method which returns height of the binary tree.
    public static int height(Node root) {
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Write a method which print the level order traversal of this tree a single line separated by a space.
    public static void levelOrder(Node root) {
        List<Node> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            Node node = list.remove(0);
            System.out.print(node.data + " ");
            if(node.left != null) list.add(node.left);
            if(node.right != null) list.add(node.right);
        }
    }

    // Write a method which returns the lowest common ancestor of two nodes.
    public static Node lca(Node root, int v1, int v2) {
        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }
        return root;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void printLinkedListForward(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();

        //Node node = new Node(3);
        //node.left = new Node(2);
        //node.left.left = new Node(1);
        //node.right = new Node(5);
        //node.right.left = new Node(4);
        //node.right.right = new Node(6);
        //node.right.right.right = new Node(7);

        //System.out.println(height(node));
        //Node root = node;

        //preOrder(root);
        //inOrder(root);
        //postOrder(root);

        //levelOrder(node);
        //preOrder(node);

        //System.out.println(lca(root, 1, 2).data);

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.right = second;
        second.left = head;
        second.right = third;
        third.left = second;
        third.right = fourth;
        fourth.left = third;

//        printLinkedListForward(addToEnd(head, 1));

//        printLinkedListForward(addToStart(head, 5));

//        printLinkedListForward(addToAfter(root, 2, 5));

//        printLinkedListForward(deleteLast(head));

//        head = deleteFirst(head);
//        printLinkedListForward(head);

//        printLinkedListForward(deleteNodeAfter(head, 5));


//        SinglyLinkedListNode one = new SinglyLinkedListNode(1);
//
//        SinglyLinkedListNode two = new SinglyLinkedListNode(2);
//        one.next = two;
//
//        SinglyLinkedListNode three = new SinglyLinkedListNode(3);
//        two.next = three;
//
//        SinglyLinkedListNode four = new SinglyLinkedListNode(4);
//          three.next = four;

//        SinglyLinkedListNode headNode = insertNodeAtPosition(one, 5, 2);
//        SinglyLinkedListNode current = headNode;
//        while (current != null) {
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//        System.out.println();

//        SinglyLinkedListNode headNode = InterviewQuestions.reverse(one);
//        SinglyLinkedListNode current = headNode;
//        while (current != null) {
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//        System.out.println();

        DoublyLinkedListNode one = new DoublyLinkedListNode(1);

        DoublyLinkedListNode two = new DoublyLinkedListNode(2);
        one.next = two;
        two.prev = one;

        DoublyLinkedListNode three = new DoublyLinkedListNode(3);
        two.next = three;
        three.prev = two;

        DoublyLinkedListNode four = new DoublyLinkedListNode(4);
        three.next = four;
        four.prev = three;

        DoublyLinkedListNode headNode = InterviewQuestions.reverses(one);
        DoublyLinkedListNode current = headNode;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }



}
