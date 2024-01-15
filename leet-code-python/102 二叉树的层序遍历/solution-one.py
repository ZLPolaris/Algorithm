from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        que = list()
        que.append(root)
        res = []
        tmp = []
        end = root
        while len(que) > 0:
            ele = que.pop(0)
            tmp.append(ele.val)
            if ele.left:
                que.append(ele.left)
                pass
            if ele.right:
                que.append(ele.right)
                pass
            if ele == end:
                res.append(tmp)
                tmp = []
                if len(que) > 0:
                    end = que[len(que) - 1]
                pass
        return res

