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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // FIXED: Handle base cases first where one or both nodes are null
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        // FIXED: Changed 'while(p && q)' to an 'if' statement with proper Java null checks
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            
            // FIXED: Capture the results of the recursive calls. 
            // If either subtree returns false, the whole comparison must fail.
            boolean leftSame = isSameTree(p.left, q.left);
            boolean rightSame = isSameTree(p.right, q.right);
            
            return leftSame && rightSame;
        }

        return true;
    }
}
