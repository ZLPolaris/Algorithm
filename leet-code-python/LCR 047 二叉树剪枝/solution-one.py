# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def pruneTree(self, root: TreeNode) -> TreeNode:
        def getPruneTree(node: TreeNode) -> bool:
            if node is None:
                return True
            bl = getPruneTree(node.left)
            if bl:
                node.left = None
                pass
            br = getPruneTree(node.right)
            if br:
                node.right = None
                pass
            return node.val == 0 and bl and br

        rootJudge = getPruneTree(root)
        return None if rootJudge else root
