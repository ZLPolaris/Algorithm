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

        def reverseList(node: Optional[TreeNode]) -> Optional[TreeNode]:
            pre = None
            cur = node
            while cur:
                tmp = cur.right
                cur.right = pre
                pre = cur
                cur = tmp
                pass
            return pre
            pass

        def visitList(node: Optional[TreeNode]):
            newHead = reverseList(node)
            p = newHead
            while p:
                res.append(p.val)
                p = p.right
                pass
            reverseList(newHead)

        roots = root
        while root:
            if root.left:
                predecessor = root.left
                if predecessor.right and predecessor.right != root:
                    predecessor = predecessor.right
                    pass
                if predecessor.right is None:
                    predecessor.right = root
                    root = root.left
                    pass
                else:
                    predecessor.right = None
                    visitList(root.left)
                    root = root.right
                    pass
                pass
            else:
                root = root.right
                pass
            pass
        visitList(roots)
        return res
        pass
