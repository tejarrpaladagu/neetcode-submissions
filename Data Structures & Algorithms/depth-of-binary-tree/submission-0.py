# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        ans = 0
        
        def helper(node, height):
            nonlocal ans # Allows us to modify the variable in the outer scope
            if not node:
                return 
            
            current_height = height + 1
            ans = max(ans, current_height) # Update the global max
            
            helper(node.left, current_height)
            helper(node.right, current_height)

        helper(root, 0)
        return ans
        