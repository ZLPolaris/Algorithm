import collections
from typing import List


# 深度优先遍历
class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        adj_list = collections.defaultdict(list)
        for edge in edges:
            adj_list[edge[0]].append(edge[1])
            adj_list[edge[1]].append(edge[0])

        visited = [0] * n

        def dfs(u):
            visited[u] = 1
            if u == destination:
                return True
            for v in adj_list[u]:
                if visited[v] == 0:
                    if dfs(v):
                        return True
            return False

        return dfs(source)
