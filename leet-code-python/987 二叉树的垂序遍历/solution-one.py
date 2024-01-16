# Definition for a binary tree node.
import bisect
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        lS = 0
        p = root
        while p.left:
            lS -= 1
            p = p.left
            pass
        rS = 0
        p = root
        while p.right:
            rS += 1
            p = p.right
            pass
        rowLength = rS - lS + 1
        res = [[] for _ in range(rowLength)]
        q = [(root, 0)]
        while q:
            n = len(q)
            tmp = []
            front = lS - 1
            for i in range(n):
                ele, column = q.pop(0)
                if column != front:
                    if front != lS - 1:
                        res[front - lS].extend(tmp)
                        tmp = []
                        pass
                    tmp.append(ele.val)
                    pass
                else:
                    index = bisect.bisect_left(tmp, ele.val)
                    tmp.insert(index, ele.val)
                    pass
                front = column
                if ele.left:
                    q.append((ele.left, column - 1))
                    pass
                if ele.right:
                    q.append((ele.right, column + 1))
                    pass
                pass
            res[front - lS].extend(tmp)
            pass
        return res
        pass
