import heapq
from typing import List


class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        father = [[(-1, -1)] * n for _ in range(n)]
        colors = [[False] * n for _ in range(n)]
        dist = [[float('inf')] * n for _ in range(n)]
        pq = [(0, 0, 0)]
        heapq.heapify(pq)
        dist[0][0] = 0
        while pq:
            w, i, j = heapq.heappop(pq)
            if colors[i][j]:
                continue
            colors[i][j] = True
            for u, v in [(i - 1, j), (i + 1, j), (i, j + 1), (i, j - 1)]:
                if 0 <= u < n and 0 <= v < n and not colors[u][v]:
                    w = max(grid[u][v], grid[i][j])
                    heapq.heappush(pq, (w, u, v))
                    if w < dist[u][v]:
                        dist[u][v] = w
                        father[u][v] = (i, j)
        big = grid[0][0]
        i = n - 1
        j = n - 1
        while father[i][j] != (-1, - 1):
            big = max(big, grid[i][j])
            i, j = father[i][j]
        return big
