from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def getSymmetric(left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
            if left is None and right is None:
                return True
            if left is None or right is None:
                return False
            q = list()
            q.append(left)
            q.append(right)
            while len(q) > 0:
                front1 = q.pop(0)
                front2 = q.pop(0)
                if front1.val != front2.val:
                    return False
                if (front1.left is None or front2.right is None) and not (front1.left is None and front2.right is None):
                    return False
                if (front1.right is None or front2.left is None) and not (front1.right is None and front2.left is None):
                    return False

                if front1.left:
                    q.append(front1.left)
                    pass
                if front2.right:
                    q.append(front2.right)
                    pass
                if front1.right:
                    q.append(front1.right)
                    pass
                if front2.left:
                    q.append(front2.left)
                    pass
                pass
            return True

        return getSymmetric(root.left, root.right)
