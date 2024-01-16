# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        pass

    pass


class Solution:
    def inorderSuccessor(self, root: 'TreeNode', p: 'TreeNode') -> 'TreeNode':
        if p.right:
            res = p.right
            while res.left:
                res = res.left
                pass
            return res
        res = None
        while root:
            if root.val > p.val:
                res = root
                root = root.left
                pass
            else:
                root = root.right
                pass
            pass
        return res
