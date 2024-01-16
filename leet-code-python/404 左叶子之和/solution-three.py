from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        q = [root]
        res = 0
        while q:
            ele = q.pop(0)
            if ele.left:
                if ele.left.left is None and ele.left.right is None:
                    res += ele.left.val
                    pass
                else:
                    q.append(ele.left)
                    pass
                pass
            if ele.right:
                q.append(ele.right)
                pass
            pass
        return res
