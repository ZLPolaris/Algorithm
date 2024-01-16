from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    first = True
    front = -1
    n = 0
    frontN = -1

    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        def LMR(node: Optional[TreeNode]):
            if node:
                LMR(node.left)
                if self.first:
                    self.n += 1
                    self.first = False
                    self.front = node.val
                    pass
                else:
                    if node.val == self.front:
                        self.n += 1
                        pass
                    else:
                        if self.n > self.frontN:
                            res.clear()
                            res.append(self.front)
                            self.frontN = self.n
                            pass
                        elif self.n == self.frontN:
                            res.append(self.front)
                            pass
                        self.front = node.val
                        self.n = 1
                LMR(node.right)
                pass
            pass

        LMR(root)
        if self.n > self.frontN:
            res.clear()
            res.append(self.front)
            pass
        elif self.n == self.frontN:
            res.append(self.front)
            pass
        return res
