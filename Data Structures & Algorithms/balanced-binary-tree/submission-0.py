# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def is_balanced(node):
            if not node:
                return True,-1
            lb,hl = is_balanced(node.left)
            rb,hr = is_balanced(node.right)

            cur_h = max(hl,hr)+1
            return (abs(hl-hr)<=1 and lb and rb),cur_h
        return is_balanced(root)[0]


        