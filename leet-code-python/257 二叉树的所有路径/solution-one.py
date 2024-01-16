from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res = []
        path = []

        def findAllPaths(node: Optional[TreeNode]) -> None:
            if node is None:
                return
            path.append(str(node.val))
            if node.left is None and node.right is None:
                res.append("->".join(path))
                path.pop()
                return
            findAllPaths(node.left)
            findAllPaths(node.right)
            path.pop()
            pass

        findAllPaths(root)
        return res
