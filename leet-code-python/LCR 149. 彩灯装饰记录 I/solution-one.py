# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def decorateRecord(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        q = [root]
        res = []
        while q:
            ele = q.pop(0)
            res.append(ele.val)
            if ele.left:
                q.append(ele.left)
                pass
            if ele.right:
                q.append(ele.right)
                pass
            pass
        return res
        pass
