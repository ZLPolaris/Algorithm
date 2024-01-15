# class TreeNode:
from typing import Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        res = 0
        s = [root]
        while s:
            ele = s.pop()
            if ele.right:
                s.append(ele.right)
                pass
            if ele.left:
                if ele.left.left is None and ele.right.right is None:
                    res += ele.left.val
                    pass
                else:
                    s.append(ele.left)
                    pass
                pass
            pass
        return res
