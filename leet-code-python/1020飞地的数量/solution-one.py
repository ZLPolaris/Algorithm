from typing import List


class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def dfs(source):
            grid[source[0]][source[1]] = 2
            stack = [source]
            while stack:
                tail = stack.pop()
                for u, v in [(tail[0] - 1, tail[1]), (tail[0] + 1, tail[1]), (tail[0], tail[1] - 1),
                             (tail[0], tail[1] + 1)]:
                    if 0 <= u < m and 0 <= v < n and grid[u][v] == 1:
                        grid[u][v] = 2
                        stack.append((u, v))

        for i in range(m):
            if grid[i][0] == 1:
                dfs((i, 0))
            if grid[i][n - 1] == 1:
                dfs((i, n - 1))
        for i in range(n):
            if grid[0][i] == 1:
                dfs((0, i))
            if grid[m - 1][i] == 1:
                dfs((m - 1, i))
        count = 0
        for i in range(1, m - 1):
            for j in range(1, n - 1):
                if grid[i][j] == 1:
                    count += 1
        return count
