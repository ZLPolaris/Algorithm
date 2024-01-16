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
    res = 0

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        if root is None:
            return 0

        def getPathSum(node: Optional[TreeNode]) -> List[int]:
            paths = []
            if node.left:
                paths.extend(getPathSum(node.left))
                pass
            if node.right:
                paths.extend(getPathSum(node.right))
                pass
            for i in range(len(paths)):
                paths[i] += node.val
                if paths[i] == targetSum:
                    self.res += 1
                    pass
                pass

            paths.append(node.val)
            if node.val == targetSum:
                self.res += 1
                pass
            print(node.val, paths)
            return paths
            pass

        getPathSum(root)
        return self.res
        pass
