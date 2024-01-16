# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    node = None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def getLowestCommonAncestor(node: 'TreeNode') -> int:
            if node is None:
                return 0
            leftCount = getLowestCommonAncestor(node.left)
            rightCount = getLowestCommonAncestor(node.right)
            if leftCount >= 2 or rightCount >= 2:
                return 2
            nodeCount = 1 if node.val == p.val or node.val == q.val else 0
            allCount = leftCount + rightCount + nodeCount
            if allCount == 2:
                self.node = node
                return 2
            else:
                return allCount
            pass
        getLowestCommonAncestor(root)
        return self.node
