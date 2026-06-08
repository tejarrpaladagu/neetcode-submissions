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
    // FIXED: Changed 'public res = 0;' to include the data type 'int'
    public int res = 0; 

    public int diameterOfBinaryTree(TreeNode root) {
        // Reset res to 0 for fresh test runs
        res = 0;
        
        // Start the recursive helper function to find heights
        calculateHeight(root);
        
        return res;
    }

    // Helper method that calculates height and updates 'res' along the way
    public int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);

        // Update your global result if the path through this node is longer
        res = Math.max(res, left + right);

        // Return the height of the current node to its parent
        return 1 + Math.max(left, right);
    }
}