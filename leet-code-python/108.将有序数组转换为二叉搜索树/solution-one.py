from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def getSortedArrayToBST(left: int, right: int) -> Optional[TreeNode]:
            if left > right:
                return None
            mid = left + (right - left) // 2
            return TreeNode(nums[mid], getSortedArrayToBST(left, mid - 1), getSortedArrayToBST(mid + 1, right))
            pass
        return getSortedArrayToBST(0, len(nums) - 1)
