# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = [root]
        end = root
        count = 0
        res = []
        tmp = []
        while q:
            ele = q.pop(0)
            tmp.append(ele.val)
            if ele.left:
                q.append(ele.left)
                pass
            if ele.right:
                q.append(ele.right)
                pass
            if ele == end:
                if q:
                    end = q[len(q) - 1]
                if count % 2 == 1:
                    tmp.reverse()
                    pass
                count += 1
                res.append(tmp)
                tmp = []
                pass
            pass
        return res
