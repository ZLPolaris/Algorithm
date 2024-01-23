import collections
from typing import List


class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        colors = [0] * n

        def bfs(source):
            colors[source] = 1
            queue = collections.deque()
            queue.append(source)
            while queue:
                u = queue.popleft()
                for v in graph[u]:
                    if colors[v] == 0:
                        colors[v] = 1 if colors[u] == 2 else 2
                        queue.append(v)
                    elif colors[v] == colors[u]:
                        return False
            return True

        for i in range(n):
            if colors[i] == 0 and not bfs(i):
                return False
        return True
