# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    def decorateRecord(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = [root]
        res = []
        isOrderLeft = True
        while q:
            n = len(q)
            tmp = []
            for i in range(n):
                ele = q.pop(0)
                if isOrderLeft:
                    tmp.append(ele.val)
                    pass
                else:
                    tmp.insert(0, ele.val)
                if ele.left:
                    q.append(ele.left)
                    pass
                if ele.right:
                    q.append(ele.right)
                    pass
                pass
            isOrderLeft = not isOrderLeft
            pass
            res.append(tmp)
            pass
        return res
        pass
