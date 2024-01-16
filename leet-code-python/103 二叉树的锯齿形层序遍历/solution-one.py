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
        isOrderLeft = True
        res = []
        while q:
            tmp = []
            n = len(q)
            if isOrderLeft:
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
                pass
            else:
                for i in range(n):
                    ele = q.pop(0)
                    tmp.insert(0, ele.val)
                    if ele.left:
                        q.append(ele.left)
                        pass
                    if ele.right:
                        q.append(ele.right)
                        pass
                pass
            isOrderLeft = not isOrderLeft
            res.append(tmp)
            pass
        return res
