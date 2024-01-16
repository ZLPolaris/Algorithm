# Definition for a binary tree node.
import functools
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        pass


class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        structNode = []
        res = []

        def flagNode(node: Optional[TreeNode], row: int, column: int):
            if node:
                structNode.append((node.val, row, column))
                flagNode(node.left, row + 1, column - 1)
                flagNode(node.right, row + 1, column + 1)
                pass
            pass

        def compare(sNode1, sNode2) -> int:
            if sNode1[2] > sNode2[2]:
                return 1
            elif sNode1[2] < sNode2[2]:
                return -1
            else:
                if sNode1[1] > sNode2[1]:
                    return 1
                elif sNode1[1] < sNode2[1]:
                    return -1
                else:
                    if sNode1[0] > sNode2[0]:
                        return 1
                    elif sNode1[0] < sNode2[0]:
                        return -1
                    else:
                        return 0

        flagNode(root, 0, 0)
        structNode.sort(key=functools.cmp_to_key(compare))
        front_column = None
        tmp = []
        for value, row, column in structNode:
            if front_column is not None and front_column != column:
                res.append(tmp)
                tmp = []
                pass
            tmp.append(value)
            front_column = column
            pass
        res.append(tmp)
        return res
