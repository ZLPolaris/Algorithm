from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        while root:
            if root.left:
                predecessor = root.left
                while predecessor.right and predecessor.right != root:
                    predecessor = predecessor.right
                    pass
                if predecessor.right is None:
                    predecessor.right = root
                    root = root.left
                    continue
                    pass
                pass
            count += 1
            if count == k:
                return root.val
            root = root.right
            pass
        pass

