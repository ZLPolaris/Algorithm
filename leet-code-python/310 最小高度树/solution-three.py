import collections
from typing import List


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        adjList = collections.defaultdict(list)
        for edge in edges:
            adjList[edge[0]].append(edge[1])
            adjList[edge[1]].append(edge[0])
            pass

        max_deep = 0
        farthest = 0    
        visited = [False] * n
        parents = [-1] * n

        def dfs(start: int, deep: int):
            nonlocal max_deep, farthest
            if deep > max_deep:
                max_deep = deep
                farthest = start
                pass
            visited[start] = True
            for neighbor in adjList[start]:
                if not visited[neighbor]:
                    dfs(neighbor, deep + 1)
                    parents[neighbor] = start
                    pass
                pass

        dfs(0, 0)
        x = farthest
        visited = [False] * n
        max_deep = 0
        dfs(x, 0)
        y = farthest
        parents[x] = -1
        path = []
        while y != -1:
            path.append(y)
            y = parents[y]
            pass
        m = len(path)
        if m % 2 == 0:
            return [path[m // 2], path[m // 2 - 1]]
        else:
            return [path[m // 2]]
