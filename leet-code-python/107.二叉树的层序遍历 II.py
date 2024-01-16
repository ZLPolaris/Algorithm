# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = [root]
        res = []
        while q:
            tmp = []
            n = len(q)
            for i in range(n):
                ele = q.pop(0)
                tmp.append(ele.val)
                if ele.left:
                    q.append(ele.left)
                    pass
                if ele.right:
                    q.append(ele.right)
                    pass
                pass
            res.append(tmp)
            pass
        res.reverse()
        return res
