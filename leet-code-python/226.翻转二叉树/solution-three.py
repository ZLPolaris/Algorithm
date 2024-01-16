from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return
        q = [root]
        while q:
            ele = q.pop(0)
            ele.left, ele.right = ele.right, ele.left
            if ele.left:
                q.append(ele.left)
                pass
            if ele.right:
                q.append(ele.right)
                pass
            pass
        return root
