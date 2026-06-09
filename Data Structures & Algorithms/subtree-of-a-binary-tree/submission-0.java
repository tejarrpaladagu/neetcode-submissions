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
    // 1. Main Method: Traverses the main 'root' tree looking for a match
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base Cases
        if (root == null) {
            // If the main tree is empty, it can't contain a subRoot (unless subRoot is also null, 
            // but LeetCode constraints state subRoot will have at least 1 node).
            return false; 
        }

        // If the trees match starting at the current node, we found it!
        if (same(root, subRoot)) {
            return true;
        }

        // Otherwise, look for the match in the left child OR the right child
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 2. Helper Method: Structural check to see if two trees are identical
    // FIXED: Moved outside of the isSubtree method and fixed the 'TreeNde' typo
    public boolean same(TreeNode p, TreeNode q) {
        // FIXED: Added null guards to prevent NullPointerExceptions
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) {
            return false;
        }

        // FIXED: Declared left and right as booleans
        boolean left = same(p.left, q.left);
        boolean right = same(p.right, q.right);

        return left && right;
    }
}
