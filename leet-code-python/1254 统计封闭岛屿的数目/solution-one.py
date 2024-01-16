from typing import List


class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def dfs(source):
            grid[source[0]][source[1]] = 2
            stack = [source]
            flag = True
            while stack:
                tail = stack.pop()
                flag = (0 < tail[0] < m - 1 and 0 < tail[1] < n - 1) if flag else flag
                for u, v in [(tail[0] - 1, tail[1]), (tail[0] + 1, tail[1]), (tail[0], tail[1] - 1),
                             (tail[0], tail[1] + 1)]:
                    if 0 <= u < m and 0 <= v < n and grid[u][v] == 0:
                        grid[u][v] = 2
                        stack.append((u, v))
            return flag

        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    if dfs((i, j)):
                        count += 1
        return count
