package leetcode.codingpatterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Template {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {

  }

  /* 🔁 Common Traversal Patterns */

  // Depth-First Search (DFS) – Recursive
  public void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    // Preorder: process before children
    dfs(root.left);
    dfs(root.right);
  }

  // Iterative DFS (using Stack)
  public void dfsIterative(TreeNode root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      // process node.val
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
  }

  // Breadth-First Search (BFS) – Level Order
  public void bfs(TreeNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        // process node.val
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
    }
  }

  /* 🧩 Key Tree Problem Templates */

  // Maximum Depth of Binary Tree
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  // Invert / Mirror a Binary Tree
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

  // Check if Two Trees Are Identical
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null || p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }


  int diameter = 0;

//  Diameter of Binary Tree
  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return diameter;
  }

  private int depth(TreeNode node) {
    if (node == null) return 0;
    int left = depth(node.left);
    int right = depth(node.right);
    diameter = Math.max(diameter, left + right);
    return 1 + Math.max(left, right);
  }

//  Lowest Common Ancestor (LCA)
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) return root;
    return left != null ? left : right;
  }

//  Level Order Traversal
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        level.add(node.val);
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
      }
      result.add(level);
    }
    return result;
  }





}
