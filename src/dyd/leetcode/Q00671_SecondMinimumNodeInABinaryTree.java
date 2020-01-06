package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 *
 * Example 2:
 *
 * Input:
 *     2
 *    / \
 *   2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class Q00671_SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null ||(root.left == null && root.right == null)) {
            return -1;
        }

        if (root.val < root.left.val) {
            return root.left.val;
        }

        if (root.val < root.right.val) {
            return root.right.val;
        }

        int left = findSecondMinimumValue(root.left);
        int right = findSecondMinimumValue(root.right);
        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        } else {
            return Math.min(left, right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        test(root);

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        test(root1);

    }

    private static void test(TreeNode root) {
        TreeUtil.printTree(root);
        Q00671_SecondMinimumNodeInABinaryTree q = new Q00671_SecondMinimumNodeInABinaryTree();
        System.out.println(q.findSecondMinimumValue(root));
    }
}
