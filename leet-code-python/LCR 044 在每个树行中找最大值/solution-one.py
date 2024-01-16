
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res = []
        q = [root]
        while q:
            n = len(q)
            first = q.pop(0)
            res.append(first.val)
            if first.left:
                q.append(first.left)
                pass
            if first.right:
                q.append(first.right)
                pass
            for i in range(n - 1):
                ele = q.pop(0)
                if ele.val > res[len(res) - 1]:
                    res[len(res) - 1] = ele.val
                    pass
                if ele.left:
                    q.append(ele.left)
                    pass
                if ele.right:
                    q.append(ele.right)
                    pass
                pass
            pass
        return res
