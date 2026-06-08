/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    // We can keep your global tracking boolean variable
    public boolean ans;

    public boolean isBalanced(TreeNode root) {
        // If our height function returns -1, it means it found an unbalanced node
        int result = calculateHeight(root);
        
        if (result == -1) {
            ans = false;
        } else {
            ans = true;
        }
        
        return ans;
    }

    // FIXED: Changed return type to int to track heights and error codes
    public int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0; // An empty tree has a height of 0
        }

        // FIXED: Call the correct method name and declare them as ints
        int left = calculateHeight(root.left);
        // If the left subtree is already unbalanced, pass the error code (-1) straight up
        if (left == -1) return -1;

        int right = calculateHeight(root.right);
        // If the right subtree is already unbalanced, pass the error code (-1) straight up
        if (right == -1) return -1;

        // FIXED: Check if the height difference breaks the balance rule
        if (Math.abs(left - right) > 1) {
            return -1; // Return our error flag!
        }

        // If it IS balanced, return its actual height to its parent node
        return 1 + Math.max(left, right);
    }
}