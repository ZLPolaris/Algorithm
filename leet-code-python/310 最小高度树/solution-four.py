import collections
from typing import List


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1:
            return [0]
        adjList = collections.defaultdict(list)
        degree = [0] * n
        for edge in edges:
            adjList[edge[0]].append(edge[1])
            adjList[edge[1]].append(edge[0])
            degree[edge[0]] += 1
            degree[edge[1]] += 1
            pass
        q = [node for node in range(n) if degree[node] == 1]
        remain = n
        while remain > 2:
            remain -= len(q)
            tmp = q
            q = []
            for ele in tmp:
                for neighbor in adjList[ele]:
                    degree[neighbor] -= 1
                    if degree[neighbor] == 1:
                        q.append(neighbor)
                        pass
                    pass
        return q
