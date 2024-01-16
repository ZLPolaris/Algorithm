# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    mistake = None
    base = None
    flag = False
    after = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.base = root
        while self.base.left:
            self.base = self.base.left
            pass

        def LMR(node: Optional[TreeNode]) -> None:
            if node:
                LMR(node.left)
                if node.val < self.base.val:
                    if self.mistake is None:
                        self.mistake = self.base
                        self.after = node
                        print(self.mistake.val)
                        pass
                    else:
                        print(self.mistake.val, node.val)
                        self.mistake.val, node.val = node.val, self.mistake.val
                        self.flag = True
                        return
                        pass
                    pass
                self.base = node
                LMR(node.right)
                pass
            pass

        LMR(root)
        if not self.flag:
            self.mistake.val, self.after.val = self.after.val, self.mistake.val
            pass
        pass
