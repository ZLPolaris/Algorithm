from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        # 统计点数的dfs
        def dfs(u, v):
            grid[u][v] = 2
            count = 1
            for i, j in [(u - 1, v), (u, v - 1), (u + 1, v), (u, v + 1)]:
                if 0 <= i < m and 0 <= j < n and grid[i][j] == 1:
                    count += dfs(i, j)
            return count

        area = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    area = max(area, dfs(i, j))
        return area