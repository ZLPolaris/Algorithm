# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def recoverFromPreorder(self, traversal: str) -> Optional[TreeNode]:
        j = 0
        number = 0
        n = len(traversal)
        while j < n and traversal[j] != '-':
            number = number * 10 + int(traversal[j])
            j += 1
            pass

        s = [TreeNode(number)]
        count = 0
        number = 0
        for i in range(j, n):
            if traversal[i] == '-':
                count += 1
                pass
            else:
                number = number * 10 + int(traversal[i])
                if i == n - 1 or traversal[i + 1] == '-':
                    node = TreeNode(number)
                    if count >= len(s):
                        s[len(s) - 1].left = node
                        s.append(node)
                        pass
                    else:
                        while count < len(s):
                            s.pop()
                            pass
                        s[len(s) - 1].right = node
                        s.append(node)
                    count = 0
                    number = 0
                    pass
        return s[0]
        pass
    pass


s = Solution()
ns = s.recoverFromPreorder("1-2--3--4-5--6--7")
