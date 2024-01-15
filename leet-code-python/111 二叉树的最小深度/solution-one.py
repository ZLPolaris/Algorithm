from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        def getMinDepth(node: Optional[TreeNode]) -> int:
            if node.left is None and node.right is None:
                return 1
            minDepth = -1
            if node.left:
                lh = getMinDepth(node.left)
                minDepth = lh + 1
                pass
            if node.right:
                rh = getMinDepth(node.right)
                if minDepth == -1:
                    minDepth = rh + 1
                    pass
                else:
                    minDepth = min(minDepth, rh + 1)
                pass
            return minDepth

        return getMinDepth(root)
