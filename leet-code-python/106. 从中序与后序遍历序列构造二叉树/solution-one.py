# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def getBuildTree(root: int, left: int, right: int) -> Optional[TreeNode]:
            if left > right:
                return None
            midIndex = findIndex(left, right, postorder[root])
            return TreeNode(postorder[root], getBuildTree(root - 1 - (right - midIndex), left, midIndex - 1),
                            getBuildTree(root - 1, midIndex + 1, right))

        def findIndex(left: int, right: int, target: int) -> int:
            i = left
            while i <= right and inorder[i] != target:
                i += 1
                pass
            return i

        return getBuildTree(len(postorder) - 1, 0, len(inorder) - 1)
        pass
