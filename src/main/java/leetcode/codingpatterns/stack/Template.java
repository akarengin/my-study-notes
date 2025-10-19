package leetcode.codingpatterns.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Template {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);   // add item
        int top = stack1.peek(); // look at top
        int val = stack1.pop();  // remove top item
        boolean empty = stack1.isEmpty();

        // You can also use for better performance:
        // (ArrayDeque is faster and not unnecessarily thread-safe, making it perfect for single-threaded algorithm problems.)
        Deque<Integer> stack2 = new ArrayDeque<>();

        Template template = new Template();
        // Test nextGreaterElements
        int[] nums = {1, 2, 4, 5, 3};
        int[] result = template.nextGreaterElements(nums);
        System.out.println("Next greater elements: " + Arrays.toString(result));

        // Test dailyTemperatures
        int[] temperatures = {73, 74, 75, 71};
        int[] result2 = template.dailyTemperatures(temperatures);
        System.out.println("Daily Temperatures: " + Arrays.toString(result2));

        // Test reversePolishNotation
        String[] tokens = new String[]{"2", "1", "4", "+", "3", "*"};
        int result3 = template.evalRPN(tokens);
        System.out.println("Reverse Polish Notation: " + result3);
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean isValidI(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public boolean isValidII(String s) {
        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();
        // Loop through the characters in the string
        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the stack is empty or doesn't match, return false
                if (stack.isEmpty() ||
                        (c == ')' && stack.pop() != '(') ||
                        (c == '}' && stack.pop() != '{') ||
                        (c == ']' && stack.pop() != '[')) {
                    return false;
                }
            }
        }
        // Return true if the stack is empty
        return stack.isEmpty();
    }

    /*
     * Returns the next greater element for each element in the given array.
     * If such element doesn't exist, set -1.
     */
    // Time complexity: O(n)
    //Space complexity: O(n)
    public int[] nextGreaterElements(int[] nums) {
        // Stack to store the numbers from the end of the array
        Stack<Integer> stack = new Stack<>();
        // Result array to store the next greater elements
        int[] res = new int[nums.length];

        // Iterate from the end of the array
        for (int i = nums.length - 1; i >= 0; i--) {
            // Pop all elements from the stack that are not greater than the current element
            while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
            // Set the next greater element for the current element
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element onto the stack
            stack.push(nums[i]);
        }
        // Return the result array
        return res;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                // Pop two operands from the stack
                int b = stack.pop(), a = stack.pop();
                // Perform the operation and push the result back onto the stack
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                // Push the number onto the stack
                stack.push(Integer.parseInt(token));
            }
        }
        // The final result is the only element left on the stack
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    /*
    * Input: temperatures = [73,74,75,71,69,72,76,73]
    * Output: [1,1,4,2,1,1,0,0]
    * */
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack to store the indices of the temperatures
        Stack<Integer> stack = new Stack<>();
        // Result array to store the number of days until a higher temperature
        int[] res = new int[temperatures.length];

        // Iterate through the temperatures array
        for (int i = 0; i < temperatures.length; i++) {
            // Pop all elements from the stack that have a lower temperature than the current element
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                // Set the number of days until a higher temperature for the previous element
                res[prev] = i - prev;
            }
            // Push the current element onto the stack
            stack.push(i);
        }
        // Return the result array
        return res;
    }


}
