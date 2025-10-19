package stack;

import java.util.*;

public class MyQueue<E> {

    Stack<E> stack1;
    Stack<E> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(E x) {
        stack1.push(x);
    }

    public void pop() {
        if(stack2.isEmpty()) {
            if(stack1.isEmpty()) {
                throw new EmptyStackException();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    public Object peek() {
        if (stack2.isEmpty()) {
            if(stack1.isEmpty()) {
                throw new EmptyStackException();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] values = line.split(" ");
            int queryType = Integer.parseInt(values[0]);

            if (queryType == 1) {
                int x = Integer.parseInt(values[1]);
                queue.push(x);

            } else {
                if (queryType == 2) {
                    queue.pop();
                } else if (queryType == 3){
                    System.out.println(queue.peek());
                }
            }
        }
        scanner.close();
    }

}
