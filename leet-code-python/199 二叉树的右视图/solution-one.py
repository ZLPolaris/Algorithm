# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        q = [root]
        res = []
        while q:
            n = len(q)
            ele = q.pop(0)
            res.append(ele.val)
            if ele.right:
                q.append(ele.right)
                pass
            if ele.left:
                q.append(ele.left)
                pass
            for i in range(n-1):
                ele = q.pop(0)
                if ele.right:
                    q.append(ele.right)
                    pass
                if ele.left:
                    q.append(ele.left)
                    pass
                pass
            pass
        return res
        pass
