import collections
import sys
from typing import List


# 会超时

class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        res = []
        minHeight = sys.maxsize
        adjList = collections.defaultdict(list)
        for edge in edges:
            adjList[edge[0]].append(edge[1])
            adjList[edge[1]].append(edge[0])
            pass

        def getTreeHeight(root: int, father: int) -> int:
            height = 0
            for v in adjList[root]:
                if v != father:
                    height = max(getTreeHeight(v, root), height)
                    pass
                pass
            return height + 1

        for i in range(n):
            h = getTreeHeight(i, -1)
            if h < minHeight:
                res = [i]
                minHeight = h
                pass
            elif h == minHeight:
                res.append(i)
                pass
            pass
        return res
