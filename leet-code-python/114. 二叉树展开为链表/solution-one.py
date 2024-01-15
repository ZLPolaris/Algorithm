from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass

    pass


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return

        def getFlatten(node: Optional[TreeNode]) -> Optional[TreeNode]:
            end = node
            leftNode = node.left
            node.left = None
            rightNode = node.right
            print(node.val)
            if leftNode:
                end = getFlatten(leftNode)
                node.right = leftNode
                pass
            if rightNode:
                rightEnd = getFlatten(rightNode)
                end.right = rightNode
                end = rightEnd
                pass
            print("end:", end.val)
            return end

        getFlatten(root)
        pass

    pass


s = Solution()
# root = TreeNode(1, TreeNode(2, TreeNode(3, None, None), TreeNode(4, None, None)),
#                 TreeNode(5, None, TreeNode(6, None, None)))
root = TreeNode(1, TreeNode(2, None, None), TreeNode(3, None, None))
s.flatten(root)

while root:
    print(root.val)
    root = root.right
    pass
