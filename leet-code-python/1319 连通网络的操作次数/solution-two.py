import collections
from typing import List


class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        m = len(connections)
        if m < n - 1:
            return -1
        adj_list = collections.defaultdict(list)
        for connection in connections:
            adj_list[connection[0]].append(connection[1])
            adj_list[connection[1]].append(connection[0])
        visited = [0] * n

        def dfs(u):
            visited[u] = 1
            for v in adj_list[u]:
                if visited[v] == 0:
                    dfs(v)

        count = 0
        for i in range(n):
            if visited[i] == 0:
                dfs(i)
                count += 1

        return count - 1
