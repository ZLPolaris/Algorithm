from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if root is None:
            return False
        q1 = list([root])
        q2 = [root.val]
        while len(q1) > 0:
            ele = q1.pop(0)
            s1 = q2.pop(0)
            if ele.left is None and ele.right is None and s1 == targetSum:
                return True
            if ele.left:
                q1.append(ele.left)
                q2.append(s1 + ele.left.val)
                pass
            if ele.right:
                q1.append(ele.right)
                q2.append(s1 + ele.right.val)
                pass
            pass
        return False
