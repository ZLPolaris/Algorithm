# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        if root.left is None and root.right is None:
            if targetSum == root.val:
                return [[root.val]]
            pass

        res = []
        tmp = (self.pathSum(root.left, targetSum - root.val)) + self.pathSum(root.right, targetSum - root.val)
        for item in tmp:
            item.insert(0, root.val)
            res.append(item)
            pass
        return res
        pass
