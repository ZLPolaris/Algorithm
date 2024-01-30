import collections
from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res = []
        n = len(graph)

        def bfs(start):
            queue = collections.deque()
            queue.append([start])
            while queue:
                path = queue.popleft()
                tail = path[-1]
                if tail == n - 1:
                    res.append(path)
                    continue
                for v in graph[tail]:
                    path.append(v)
                    queue.append(path.copy())
                    path.pop()

        bfs(0)
        return res
