import collections
from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def bfs(source):
            queue = collections.deque()
            queue.append(source)
            count = 1
            grid[source[0]][source[1]] = 0
            while queue:
                l, s = queue.popleft()
                for u, v in [(l - 1, s), (l + 1, s), (l, s - 1),
                             (l, s + 1)]:
                    if 0 <= u < m and 0 <= v < n and grid[u][v] == 1:
                        count += 1
                        grid[u][v] = 0
                        queue.append((u, v))
            return count

        max_count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    c = bfs((i, j))
                    max_count = max(c, max_count)
        return max_count
