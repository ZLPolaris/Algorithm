# Definition for a binary tree node.
from typing import Optional, List


# 莫里斯遍历实现前序遍历

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        while root:
            if root.left:
                predecessor = root.left
                while predecessor.right and predecessor.right != root:
                    predecessor = predecessor.right
                    pass
                if predecessor.right is None:
                    res.append(root.val)
                    predecessor.right = root
                    root = root.left
                    pass
                else:
                    predecessor.right = None
                    root = root.right
                    pass
                pass
            else:
                res.append(root.val)
                root = root.right
                pass
            pass
        return res
