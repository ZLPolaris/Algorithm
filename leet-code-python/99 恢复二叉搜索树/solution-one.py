import sys
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
        if root:
            self.recoverTree(root.left)
            print(root.val)
            self.recoverTree(root.right)
            pass
        pass
    #     base = root
    #     while base.left:
    #         base = base.left
    #         pass
    #     mistake = None
    #     while root:
    #         if root.left:
    #             predecessor = root.left
    #             while predecessor.right is not None and predecessor.right != root:
    #                 predecessor = predecessor.right
    #                 pass
    #             if predecessor.right is None:
    #                 predecessor.right = root
    #                 root = root.left
    #                 pass
    #             else:
    #                 if root.val < base.val:
    #                     if mistake is None:
    #                         mistake = base
    #                         pass
    #                     else:
    #                         mistake.val, root.val = root.val, mistake.val
    #                         return
    #                     pass
    #                 base = root
    #                 print(root.val)
    #                 root = root.right
    #                 pass
    #             pass
    #         else:
    #             if root.val < base.val:
    #                 if mistake is None:
    #                     mistake = base
    #                     pass
    #                 else:
    #                     mistake.val, root.val = root.val, mistake.val
    #                     return
    #                 pass
    #             base = root
    #             root = root.right
    #             pass
    #         pass
    #     pass
    # pass


