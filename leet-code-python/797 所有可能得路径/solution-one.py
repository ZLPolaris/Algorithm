from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        path = [0]
        res = []
        n = len(graph)

        def dfs(u: int):
            if u == n - 1:
                tmp = [i for i in path]
                res.append(tmp)
                return
            for v in graph[u]:
                path.append(v)
                dfs(v)
                path.pop()
                pass
            pass
        dfs(0)
        return res
