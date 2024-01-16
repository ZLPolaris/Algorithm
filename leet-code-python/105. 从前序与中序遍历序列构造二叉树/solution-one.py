# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def findIndex(left: int, right: int, target: int) -> int:
            i = left
            while i <= right and inorder[i] != target:
                i += 1
                pass
            return i

        def getBuildTree(root: int, left: int, right: int) -> Optional[TreeNode]:
            if left > right:
                return None
            midIndexInorder = findIndex(left, right, preorder[root])
            rightRoot = root + midIndexInorder - left + 1
            return TreeNode(preorder[root], getBuildTree(root + 1, left, midIndexInorder - 1),
                            getBuildTree(rightRoot, midIndexInorder + 1, right))

        return getBuildTree(0, 0, len(inorder) - 1)
        pass
