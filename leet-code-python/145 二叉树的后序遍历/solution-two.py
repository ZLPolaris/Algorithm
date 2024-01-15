# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        node = root
        while node:
            if node.left:
                predecessor = node.left
                while predecessor.right and predecessor.right != node:
                    predecessor = predecessor.right
                    pass
                if predecessor.right is None:
                    predecessor.right = node
                    node = node.left
                    pass
                else:
                    predecessor.right = None
                    print(node.left.val)
                    self.visitList(node.left, res)
                    node = node.right
                    pass
                pass
            else:
                node = node.right
                pass
            pass
        self.visitList(root, res)
        return res
        pass

    def reverseList(self, node: Optional[TreeNode]) -> Optional[TreeNode]:
        pre = None
        cur = node
        while cur:
            tmp = cur.right
            cur.right = pre
            pre = cur
            cur = tmp
            pass
        return pre

    def visitList(self, node: Optional[TreeNode], res: List[int]):
        newHead = self.reverseList(node)
        p = newHead
        while p:
            res.append(p.val)
            p = p.right
            pass
        self.reverseList(newHead)
        pass
