from typing import List


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        visited = [False] * n

        def bfs(u):
            q = [u]
            visited[u] = True
            while q:
                u = q.pop(0)
                for v in range(n):
                    if isConnected[u][v] == 1 and not visited[v]:
                        visited[v] = True
                        q.append(v)
                        pass

        res = 0
        for i in range(n):
            print(visited)
            if not visited[i]:
                bfs(i)
                res += 1
                pass
        return res
        pass
