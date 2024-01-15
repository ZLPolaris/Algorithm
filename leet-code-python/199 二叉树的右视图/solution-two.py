from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        res = []
        s = [(root, 0)]
        while s:
            ele, dep = s.pop()
            if dep == len(res):
                res.append(ele.val)
                pass
            if ele.left:
                s.append((ele.left, dep + 1))
                pass
            if ele.right:
                s.append((ele.right, dep + 1))
        return res
        pass
