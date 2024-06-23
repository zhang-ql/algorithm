package com.zql.algorithm.Ztree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeConstruction {
    public TreeNode buildTree(int[] preOrder) {
        return buildTree(preOrder, 0);
    }

    private TreeNode buildTree(int[] preOrder, int k) {
        if (k == preOrder.length || preOrder[k] == Integer.MIN_VALUE) return null;

        TreeNode root = new TreeNode(preOrder[k++]);
        root.left = buildTree(preOrder, k);
        root.right = buildTree(preOrder, k);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, Integer.MIN_VALUE, 5, Integer.MIN_VALUE, 4}; // 使用Integer.MIN_VALUE代替null
        TreeNode root = new BinaryTreeConstruction().buildTree(preorder);
    }
}
