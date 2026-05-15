# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        #diameter should pass through a node,we'll find max from each and take global max
        res = 0
        def dfs(node):
            nonlocal res
            if not node:
                return -1
            lft,rgt = dfs(node.left),dfs(node.right)
            res = max(res,2+ lft+rgt)
            return 1+ max(lft,rgt)
        _ = dfs(root)
        return res
            


        