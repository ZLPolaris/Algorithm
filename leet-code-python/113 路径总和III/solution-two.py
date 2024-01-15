# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []

        res = []
        path = []

        def getPathSum(node: Optional[TreeNode], target: int):
            if node.left is None and node.right is None:
                if node.val == target:
                    tmp = path[:]
                    tmp.append(node.val)
                    res.append(tmp)
                    pass
                return
            if node.left:
                path.append(node.val)
                getPathSum(node.left, target - node.val)
                path.pop()
                pass
            if node.right:
                path.append(node.val)
                getPathSum(node.right, target - node.val)
                path.pop()
                pass
            pass

        getPathSum(root, targetSum)
        return res
