from typing import List


class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        flag = [0] * n

        def bfs(start: int) -> bool:
            q = [start]
            flag[start] = 1
            while q:
                u = q.pop(0)
                for v in graph[u]:
                    if flag[v] == 0:
                        flag[v] = 1 if flag[u] == 2 else 2
                        q.append(v)
                        pass
                    elif flag[v] == flag[u]:
                        return False
                    pass
                pass
            return True
        for i in range(n):
            if flag[i] == 0:
                if not bfs(i):
                    return False
        return True
