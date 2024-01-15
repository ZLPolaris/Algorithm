from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        mistake = None
        mistakeAfter = None
        base = root
        while base.left:
            base = base.left
            pass
        while root:
            if root.left:
                predecessor = root.left
                while predecessor.right is not None and predecessor.right != root:
                    predecessor = predecessor.right
                    pass
                if predecessor.right is None:
                    predecessor.right = root
                    root = root.left
                    continue
                    pass
                pass
            if root.val < base.val:
                if mistake is None:
                    mistake = base
                    mistakeAfter = root
                    pass
                else:
                    mistake.val, root.val = root.val, mistake.val
                    return
            base = root
            root = root.right
            pass
        mistake.val, mistakeAfter.val = mistakeAfter.val, mistake.val

