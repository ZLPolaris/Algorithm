# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class BSTIterator:
    root = None
    s = []

    def __init__(self, root: TreeNode):
        self.root = root
        self.findLeft(root)
        pass

    def next(self) -> int:
        ele = self.s.pop()
        self.findLeft(ele.right)
        return ele.val

    pass

    def hasNext(self) -> bool:
        return len(self.s) > 0
        pass

    def findLeft(self, node: TreeNode):
        while node:
            self.s.append(node)
            node = node.left
            pass

    pass

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
