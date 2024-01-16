class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# 不知道为什么报错

class Solution:
    def treeToDoublyList(self, root: 'Node') -> 'Node':
        pre = None
        first = None
        while root:
            if root.left:
                predecessor = root.left
                while predecessor.right and predecessor.right != root:
                    predecessor = predecessor.right
                    pass
                if predecessor.right is None:
                    predecessor.right = root
                    root = root.left
                    continue
                    pass
            if pre is not None:
                pre.right = root
                root.left = pre
                pass
            else:
                first = root
                pass
            pre = root
            root = root.right
            pass
        first.left = pre
        pre.right = first
        return first
