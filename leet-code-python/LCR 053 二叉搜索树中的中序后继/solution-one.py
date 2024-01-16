# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        pass

    pass


class Solution:
    def inorderSuccessor(self, root: 'TreeNode', p: 'TreeNode') -> 'TreeNode':
        if p.right:
            res = p.right
            while res.left:
                res = res.left
                return res
        path = []
        while root:
            path.append(root)
            print(path[len([path])-1].val)
            if root.val > p.val:
                root = root.left
                pass
            elif root.val < p.val:
                root = root.right
                pass
            else:
                break
                pass
            pass
        if root.right:
            res = root.right
            while res.left:
                res = res.left
                pass
            return res
        else:
            for i in range(len(path) - 1, -1, -1):
                print(path[i].val)
                if path[i].val > p.val:
                    return path[i]
        pass
