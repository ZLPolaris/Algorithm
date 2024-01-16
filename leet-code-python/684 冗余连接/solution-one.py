import collections
from typing import List


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        adjList = collections.defaultdict(list)
        for edge in edges:
            adjList[edge[0]].append(edge[1])
            adjList[edge[1]].append(edge[0])
            pass

        visited = [0] * n
        parents = [-1] * n
        end, start = -1, -1

        def dfs(u: int):
            visited[u - 1] = 1
            print(u)
            for v in adjList[u]:
                if v == parents[u - 1]:
                    continue
                if visited[v - 1] == 0:
                    parents[v - 1] = u
                    dfs(v)
                    pass
                elif visited[v - 1] == 1:
                    nonlocal end, start
                    start = v
                    end = u
            visited[u - 1] = 2
            pass

        dfs(1)
        print(parents)
        loop = []
        while end != start:
            loop.append(end)
            end = parents[end - 1]
            pass
        loop.append(start)
        for i in range(n - 1, -1, -1):
            if edges[i][0] in loop and edges[i][1] in loop:
                return edges[i]
        pass
