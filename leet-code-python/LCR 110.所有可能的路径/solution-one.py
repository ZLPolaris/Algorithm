from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res = []
        path = [0]
        n = len(graph)

        def dfs(u):
            if u == n - 1:
                res.append(path.copy())
                return
            for v in graph[u]:
                path.append(v)
                dfs(v)
                path.pop()
        dfs(0)
        return res
