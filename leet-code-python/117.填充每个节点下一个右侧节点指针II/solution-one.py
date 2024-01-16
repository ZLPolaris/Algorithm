class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        head = root
        while head:
            p = head
            head = None
            while p is not None:
                if p.left:
                    head = p.left
                    break
                if p.right:
                    head = p.right
                    break
                p = p.next
                pass

            if head is None:
                continue
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
        return root

    pass
