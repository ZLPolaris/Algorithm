from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    n = 0

    def countNodes(self, root: Optional[TreeNode]) -> int:
        def getCountNodes(node: Optional[TreeNode]):
            if node:
                self.n += 1
                self.countNodes(node.left)
                self.countNodes(node.right)
                pass
            pass
        getCountNodes(root)
        return self.n
    pass
