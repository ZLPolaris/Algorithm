# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional, List


class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        stackLeft = []
        stackRight = []
        tmp = root
        while tmp:
            stackLeft.append(tmp)
            tmp = tmp.left
            pass
        tmp = root
        while tmp:
            stackRight.append(tmp)
            tmp = tmp.right
            pass
        while stackLeft[-1].val < stackRight[-1].val:
            if stackLeft[-1].val + stackRight[-1].val == k:
                return True
            elif stackLeft[-1].val + stackRight[-1].val < k:
                self.leftNext(stackLeft)
                pass
            else:
                self.rightNext(stackRight)
                pass
        return False
        pass

    def leftNext(self, stack: List[TreeNode]) -> None:
        tmp = stack.pop().right
        while tmp:
            stack.append(tmp)
            tmp = tmp.left
            pass
        pass

    def rightNext(self, stack: List[TreeNode]) -> None:
        tmp = stack.pop().left
        while tmp:
            stack.append(tmp)
            tmp = tmp.right
            pass
        pass
