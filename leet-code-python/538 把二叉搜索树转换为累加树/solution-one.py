# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        count = 0
        node = root
        while root:
            if root.right:
                predecessor = root.right
                while predecessor.left and predecessor.left != root:
                    predecessor = predecessor.left
                    pass
                if predecessor.left is None:
                    predecessor.left = root
                    root = root.right
                else:
                    count += root.val
                    root.val = count
                    predecessor.left = None
                    root = root.left
                pass
            else:
                count += root.val
                root.val = count
                root = root.left
            pass
        return node
    pass
