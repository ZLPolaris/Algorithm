# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        pass


class Solution:
    def isSubStructure(self, A: TreeNode, B: TreeNode) -> bool:
        if A is None or B is None:
            return False
        return self.isSameStructure(A, B) or self.isSubStructure(A.left, B) or self.isSubStructure(A.right, B)
        pass

    def isSameStructure(self, A: TreeNode, B: TreeNode) -> bool:
        if B is None:
            return True
        if A is None:
            return False
        return A.val == B.val and self.isSameStructure(A.left, B.left) and self.isSameStructure(A.right, B.right)
