package leetcode.codingpatterns.stack;


import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // Test nextGreaterElement
        Solution solution = new Solution();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = solution.nextGreaterElementI(nums1, nums2);
        System.out.println("Next greater elements: " + Arrays.toString(result));


    }

    class MinStack1 {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack1() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                minStack.push(Math.min(val, minStack.peek()));
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class MinStack2 {
        int min = Integer.MAX_VALUE;
        Stack<Integer> st = new Stack<>();

        public void push(int val) {
            if (val <= min) {
                st.push(min); // Store previous min before updating
                min = val;
            }
            st.push(val);
        }

        public void pop() {
            if (st.pop() == min) {
                min = st.pop(); // Restore previous min
            }
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return min;
        }
    }


    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }

    // Time complexity : O(n)
    // Space complexity : O(n)
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    private class State {
        String currStr;
        int openCount;
        int closeCount;

        State(String currStr, int openCount, int closeCount) {
            this.currStr = currStr;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<State> st = new Stack<>();
        st.push(new State("", 0, 0));

        while (!st.isEmpty()) {
            State temp = st.pop();

            if (temp.currStr.length() == 2 * n) {
                result.add(temp.currStr);
                continue;
            }
            if (temp.openCount < n) {
                st.push(new State(temp.currStr + "(", temp.openCount + 1, temp.closeCount));
            }
            if (temp.closeCount < temp.openCount) {
                st.push(new State(temp.currStr + ")", temp.openCount, temp.closeCount + 1));
            }
        }
        return result;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 &&
                    stack.peek() <= stack.get(stack.size() - 2)) stack.pop();
        }
        return stack.size();
    }


}
