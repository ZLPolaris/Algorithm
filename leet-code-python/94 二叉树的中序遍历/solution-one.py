from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        while root:
            if root.left:
                predecessor = root.left
                while predecessor.right and predecessor.right != root:
                    predecessor = predecessor.right
                    pass
                if predecessor.right is None:
                    predecessor.right = root
                    root = root.left
                    pass
                else:
                    res.append(root.val)
                    root = root.right
                    pass
                pass
            else:
                res.append(root.val)
                root = root.right
                pass
            pass
        return res
