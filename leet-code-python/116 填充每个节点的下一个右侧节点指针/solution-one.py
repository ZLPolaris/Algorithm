class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return root
        q = [root]
        while q:
            n = len(q)
            preNode = q.pop(0)
            if preNode.left:
                q.append(preNode.left)
                pass
            if preNode.right:
                q.append(preNode.right)
                pass
            for i in range(n - 1):
                ele = q.pop(0)
                preNode.next = ele
                preNode = ele
                if ele.left:
                    q.append(ele.left)
                    pass
                if ele.right:
                    q.append(ele.right)
                    pass
                pass
            pass
        return root
