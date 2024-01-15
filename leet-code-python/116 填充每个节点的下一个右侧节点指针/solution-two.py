class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        head = root
        while head:
            p = head
            head = None
            while head is None and p is not None:
                if p.left:
                    head = p.left
                if p.right:
                    head = p.right
                    pass
                p = p.next
                pass
            if head is None:
                continue
                pass
            print(head.val)
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
            pre.next = None
        pass
    pass


