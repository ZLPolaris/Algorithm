import collections
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def bfs(source):
            q = collections.deque()
            q.append(source)
            grid[source[0]][source[1]] = "2"
            while q:
                tail = q.popleft()
                print(tail)
                if tail[0] > 0 and grid[tail[0] - 1][tail[1]] == "1":
                    q.append((tail[0] - 1, tail[1]))
                    grid[tail[0] - 1][tail[1]] = "2"
                if tail[0] < m - 1 and grid[tail[0] + 1][tail[1]] == "1":
                    q.append((tail[0] + 1, tail[1]))
                    grid[tail[0] + 1][tail[1]] = "2"
                if tail[1] > 0 and grid[tail[0]][tail[1] - 1] == "1":
                    q.append((tail[0], tail[1] - 1))
                    grid[tail[0]][tail[1] - 1] = "2"
                if tail[1] < n - 1 and grid[tail[0]][tail[1] + 1] == "1":
                    q.append((tail[0], tail[1] + 1))
                    grid[tail[0]][tail[1] + 1] = "2"

        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    bfs((i, j))
                    print(grid)
                    ans += 1
        return ans
