# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    deep = -1
    res = -1

    def findBottomLeftValue(self, root: TreeNode) -> int:
        def getFindBottomLeftValue(node: TreeNode, deepVal: int):
            if node is None:
                return
            if deepVal > self.deep:
                self.deep = deepVal
                self.res = node.val
                pass
            getFindBottomLeftValue(node.left, deepVal + 1)
            getFindBottomLeftValue(node.right, deepVal + 1)

        pass
        getFindBottomLeftValue(root, 0)
        return self.res
