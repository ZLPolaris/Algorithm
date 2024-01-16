import sys
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        base = -sys.maxsize - 1
        while root:
            if root.left:
                predecessor = root.left
                while predecessor.right is not None and predecessor.right != root:
                    predecessor = predecessor.right
                    pass
                if predecessor.right is None:
                    predecessor.right = root
                    root = root.left
                    pass
                else:
                    if root.val <= base:
                        return False
                    else:
                        base = root.val
                        pass
                    root = root.right
                    pass
                pass
            else:
                if root.val <= base:
                    return False
                else:
                    base = root.val
                    pass
                root = root.right
                pass
            pass
        return True
