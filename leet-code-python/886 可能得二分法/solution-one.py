import collections
from typing import List


class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        adj_list = collections.defaultdict(list)
        for edge in dislikes:
            adj_list[edge[0]].append(edge[1])
            adj_list[edge[1]].append(edge[0])
            pass
        visited = [0] * (n + 1)

        def bfs(start: int):
            q = [start]
            visited[start] = 1
            while q:
                cur = q.pop(0)
                for v in adj_list[cur]:
                    if visited[v] == 0:
                        visited[v] = 1 if visited[cur] == 2 else 2
                        q.append(v)
                        pass
                    elif visited[v] == visited[cur]:
                        return False
                    pass
                pass
            return True

        for i in range(1, n + 1):
            if visited[i] == 0 and not bfs(i):
                return False
        return True
