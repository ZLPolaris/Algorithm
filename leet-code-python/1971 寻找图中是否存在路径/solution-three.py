import collections
from typing import List


class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        adj_list = collections.defaultdict(list)
        for edge in edges:
            adj_list[edge[0]].append(edge[1])
            adj_list[edge[1]].append(edge[0])

        def bfs():
            visited = [0] * n
            queue = collections.deque()
            visited[source] = 1
            queue.append(source)
            while queue:
                u = queue.popleft()
                if u == destination:
                    return True
                for v in adj_list[u]:
                    if visited[v] == 0:
                        visited[v] = 1
                        queue.append(v)
            return False

        return bfs()
