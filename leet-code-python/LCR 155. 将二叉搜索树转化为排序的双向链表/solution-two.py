class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    pre = None
    head = None

    def treeToDoublyList(self, root: 'Node') -> 'Node':
        if root is None:
            return root

        def dfs(node: 'Node'):
            if node:
                dfs(node.left)
                if self.pre:
                    self.pre.right, node.left = node, self.pre
                    pass
                else:
                    self.head = node
                    pass
                self.pre = node
                dfs(node.right)
                pass
            pass

        dfs(root)
        self.head.left, self.pre.right = self.pre, self.head
        return self.head
