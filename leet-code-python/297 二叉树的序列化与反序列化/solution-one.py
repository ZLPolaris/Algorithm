# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if root:

            str1 = str(root.val) + ","
            str1 += self.serialize(root.left)
            str1 += self.serialize(root.right)
            return str1
        else:
            return "None,"

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        str1 = data.split(",")

        def buildTree():
            if str1[0] != "None":
                node = TreeNode(int(str1[0]))
                str1.pop(0)
                node.left = buildTree()
                node.right = buildTree()
                return node
            else:
                str1.pop(0)
                return None
            pass

        return buildTree()

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
