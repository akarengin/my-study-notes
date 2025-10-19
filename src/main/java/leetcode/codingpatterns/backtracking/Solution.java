package leetcode.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // --- Test case for binaryTreePaths ---
        System.out.println("--- Testing binaryTreePaths ---");

        // Create a sample binary tree:
        // 1
        // / \
        // 2 3
        // \
        // 5
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.left = new Solution.TreeNode(2);
        root.right = new Solution.TreeNode(3);
        root.left.right = new Solution.TreeNode(5);

        // Call the method and print the result
        List<String> paths = solution.binaryTreePaths(root);
        System.out.println("Input tree: [1, 2, 3, null, 5]");
        System.out.println("Output paths: " + paths);
        System.out.println();

        // Test with a null root
        System.out.println("Input tree: null");
        List<String> pathsForNull = solution.binaryTreePaths(null);
        System.out.println("Output paths: " + pathsForNull);
        System.out.println();

        // Test with a single node tree
        Solution.TreeNode singleNode = new Solution.TreeNode(10);
        System.out.println("Input tree: [10]");
        List<String> pathsForSingleNode = solution.binaryTreePaths(singleNode);
        System.out.println("Output paths: " + pathsForSingleNode);
        System.out.println("---------------------------------");
        System.out.println();

        int[] testInputs = { 0, 1, 2, 3, 4, 8, 9, 10, -1, 11 };
        for (int turnedOn : testInputs) {
            List<String> times = solution.readBinaryWatch(turnedOn);
            System.out.println("LEDs on: " + turnedOn + " => " + times);
        }

        System.out.println("\n--- Testing permute ---");
        int[] numsToPermute = { 1, 2, 3 };
        List<List<Integer>> permutations = solution.permute(numsToPermute);
        System.out.println("Input array for permute: " + Arrays.toString(numsToPermute));
        System.out.println("Permutations: " + permutations);
        System.out.println("-----------------------");
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int subsetXORSumI(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        generateSubSets(0, nums, new ArrayList<>(), subSets);
        return subSets.stream()
            .mapToInt(subset -> subset.stream().reduce(0, (a, b) -> a ^ b))
            .sum();
    }

    private void generateSubSets(int start, int[] nums, List<Integer> path,
        List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            generateSubSets(i + 1, nums, path, res);
            path.removeLast();
        }
    }

    public int subsetXORSumII(int[] nums) {
        return XORSum(nums, 0, 0);
    }

    private int XORSum(int[] nums, int index, int currentXOR) {
        // Return currentXOR when all elements in nums are already considered
        if (index == nums.length) {
            return currentXOR;
        }

        // Calculate sum of subset xor with current element
        int withElement = XORSum(nums, index + 1, currentXOR ^ nums[index]);

        // Calculate sum of subset xor without current element
        int withoutElement = XORSum(nums, index + 1, currentXOR);

        // Return sum of xor totals
        return withElement + withoutElement;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        backtrack(root, new StringBuilder(), result);
        return result;
    }

    private void backtrack(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null)
            return;

        int len = path.length();
        if (len > 0)
            path.append("->");
        path.append(node.val);

        if (node.left == null && node.right == null) {
            result.add(path.toString());
        }

        backtrack(node.left, path, result);
        backtrack(node.right, path, result);

        path.setLength(len); // Backtrack by restoring original length
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        backtrack(turnedOn, 0, 0, 0, result);
        return result;
    }

    private void backtrack(int ledsLeft, int start, int hours, int minutes, List<String> result) {
        if (hours > 11 || minutes > 59)
            return;
        if (ledsLeft == 0) {
            result.add(String.format("%d:%02d", hours, minutes));
            return;
        }
        for (int i = start; i < 10; i++) {
            if (i < 4) {
                // hour LEDs
                backtrack(ledsLeft - 1, i + 1, hours | (1 << i), minutes, result); // | is same with ^
            } else {
                // minute LEDs
                backtrack(ledsLeft - 1, i + 1, hours, minutes | (1 << (i - 4)), result);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void permute(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            path.add(nums[i]);
            permute(nums, path, used, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        // ✅ Change 1: Sort the array to group duplicates together.
        Arrays.sort(nums); 
        
        permutes(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void permutes(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Standard check: if the element is already in the current path, skip.
            if (used[i]) {
                continue;
            }

            // ✅ Change 2: The corrected logic for skipping duplicates.
            // If the current element is a duplicate of the previous one,
            // and the previous one hasn't been used (meaning we've already
            // backtracked from it), we skip the current element to avoid 
            // generating a duplicate permutation.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Standard backtracking: choose, explore, unchoose
            used[i] = true;
            path.add(nums[i]);
            permutes(nums, path, used, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
