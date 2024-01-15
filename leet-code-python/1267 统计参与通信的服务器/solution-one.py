class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        row = [0] * m
        column = [0] * n
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    row[i] += 1
                    column[j] += 1
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    if row[i] != 1 or column[j] != 1:
                        ans += 1
        return ans
