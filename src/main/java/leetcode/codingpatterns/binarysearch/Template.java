package leetcode.codingpatterns.binarysearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Template {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Binary search
    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Not found
    }

    // Lower Bound (First Occurrence or Insertion Point)
    public int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // Upper Bound (Last Occurrence + 1)
    public int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Used when elements are not sorted or not directly searchable — e.g., in optimization problems
    public int searchMinValue(int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValid(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isValid(int mid) {

        return false;
    }



    // Binary tree: DFS (recursive)
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        // do logic
        dfs(root.left);
        dfs(root.right);
        return ans;
    }

    // Binary tree: DFS (iterative)
    public int dfs1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            // do logic
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return ans;
    }

    // Binary tree: BFS
    public int fn2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;

        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            // do logic for current level

            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                // do logic
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }
}
