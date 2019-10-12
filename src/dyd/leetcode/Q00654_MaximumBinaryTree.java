package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.Arrays;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class Q00654_MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int pos = -1;
        for (int i = start; i < end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                pos = i;
            }
        }

        TreeNode node = new TreeNode(max);
        if (pos > start) {
            node.left = constructMaximumBinaryTree(nums, start, pos);
        }
        if (pos + 1 < end) {
            node.right = constructMaximumBinaryTree(nums, pos + 1, end);
        }
        return node;
    }

    public static void main(String[] args) {
        test(new int[] {3,2,1,6,0,5});
    }

    private static void test(int[] nums) {
        System.out.println(Arrays.toString(nums));
        Q00654_MaximumBinaryTree q = new Q00654_MaximumBinaryTree();
        TreeUtil.printTree(q.constructMaximumBinaryTree(nums));
    }
}
