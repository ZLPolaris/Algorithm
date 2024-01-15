from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    maxValue = float("-inf")

    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        def getMaxPathSum(node: Optional[TreeNode]) -> int:
            if not node:
                return 0
            leftMax = getMaxPathSum(node.left)
            rightMax = getMaxPathSum(node.right)
            if leftMax > 0 and rightMax > 0:
                nodeMaxValue = node.val + leftMax + rightMax
                if nodeMaxValue > self.maxValue:
                    self.maxValue = nodeMaxValue
                    pass
                return node.val + (leftMax if leftMax > rightMax else rightMax)
            elif leftMax > 0:
                nodeMaxValue = node.val + leftMax
                if nodeMaxValue > self.maxValue:
                    self.maxValue = nodeMaxValue
                    pass
                return node.val + leftMax
            elif rightMax > 0:
                nodeMaxValue = node.val + rightMax
                if nodeMaxValue > self.maxValue:
                    self.maxValue = nodeMaxValue
                    pass
                return node.val + rightMax
            else:
                if node.val > self.maxValue:
                    self.maxValue = node.val
                    pass
                return node.val
            pass

        getMaxPathSum(root)
        return self.maxValue
