package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    private StringBuilder current;
    private Deque<StringBuilder> stack;

    public SimpleTextEditor() {
        current = new StringBuilder();
        stack = new ArrayDeque<>();
        stack.push(new StringBuilder(current));
    }

    private void append(String w) {
        current.append(w);
        stack.push(new StringBuilder(current));
    }

    private void delete(int k) {
        if (k <= current.length()) {
            current.delete(current.length() - k, current.length());
            stack.push(new StringBuilder(current));
        } else {
            System.err.println("Delete operation exceeds current string length.");
        }
    }

    private void print(int k) {
        if (k > 0 && k <= current.length()) {
            System.out.println(current.charAt(k - 1));
        } else {
            System.err.println("Print operation index out of bounds.");
        }
    }

    private void undo() {
        if (stack.size() > 1) {
            stack.pop();
            current = new StringBuilder(stack.peek());
        } else {
            System.err.println("No operation to undo.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        SimpleTextEditor simpleTextEditor = new SimpleTextEditor();

        for(int i = 0; i < n; i++) {
            int q = scan.nextInt();
            switch(q) {
                case 1:
                    simpleTextEditor.append(scan.next());
                    break;
                case 2:
                    simpleTextEditor.delete(scan.nextInt());
                    break;
                case 3:
                    simpleTextEditor.print(scan.nextInt());
                    break;
                case 4:
                    simpleTextEditor.undo();
                    break;
                default:
                    System.err.println("Invalid operation: " + q);
                    break;
            }
        }
        scan.close();
    }
}
