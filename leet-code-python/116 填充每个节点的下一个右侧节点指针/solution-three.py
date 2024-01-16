class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
        pass

    pass


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return root
        head = root
        while head.left:
            p = head
            head = head.left
            pre = head
            while p:
                if p.left:
                    pre.next = p.left
                    pre = p.left
                    pass
                if p.right:
                    pre.next = p.right
                    pre = p.right
                    pass
                p = p.next
                pass
            pass
        return root
