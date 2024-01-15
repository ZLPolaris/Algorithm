import collections
from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def bfs(p, q):
            count = 1
            grid[p][q] = 2
            que = collections.deque()
            que.append((p, q))
            while que:
                l, k = que.popleft()
                for u, v in [(l - 1, k), (l, k - 1), (l + 1, k), (l, k + 1)]:
                    if 0 <= u < m and 0 <= v < n and grid[u][v] == 1:
                        grid[u][v] = 2
                        count += 1
                        que.append((u, v))
            return count

        area = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    area = max(area, bfs(i, j))
        return area
