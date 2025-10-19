package leetcode.codingpatterns.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static class TreeNode {

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

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2; // middle element
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        // Update global diameter at each node
        diameter = Math.max(diameter, left + right);

        // Return height for current node
        return 1 + Math.max(left, right);
    }

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return isBalanced;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!isBalanced) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;

        }

        return 1 + Math.max(left, right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;  // check from current node
        }
        // otherwise, search left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

    /* ------------------- Medium ----------------------*/

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int num : to_delete) {
            set.add(num);
        }
        List<TreeNode> forest = new ArrayList<>();
        root = dfs(root, set, forest);
        if (root != null) {
            forest.add(root);
        }
        return forest;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> forest) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left, set, forest);
        root.right = dfs(root.right, set, forest);
        if (set.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }
            if (root.right != null) {
                forest.add(root.right);
            }
            return null;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.left.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.right.val > high) {
            return trimBST(root.left, low, high);
        }
        root.right = trimBST(root.right, low, high);
        root.left = trimBST(root.left, low, high);
        return root;
    }

    public Node connect(Node root) {
        if (root == null) return  null;
        if (root.left != null ) root.left.next = root.right;
        if (root.next != null && root.right != null) root.right.next = root.next.left;
        root.left = connect(root.left);
        root.right = connect(root. right);
        return root;
    }


}
