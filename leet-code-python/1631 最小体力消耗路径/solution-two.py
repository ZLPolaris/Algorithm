import heapq
from typing import List


class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m = len(heights)
        n = len(heights[0])
        colors = [[False] * n for _ in range(m)]
        pq = [(0, 0, 0)]
        heapq.heapify(pq)
        big_w = 0
        while pq:
            w, i, j, = heapq.heappop(pq)
            if colors[i][j]:
                continue
            colors[i][j] = True
            big_w = max(big_w, w)
            if i == m - 1 and j == n - 1:
                break
            for u, v in [(i + 1, j), (i - 1, j), (i, j - 1), (i, j + 1)]:
                if 0 <= u < m and 0 <= v < n and not colors[u][v]:
                    heapq.heappush(pq, (abs(heights[i][j] - heights[u][v]), u, v))
        return big_w
