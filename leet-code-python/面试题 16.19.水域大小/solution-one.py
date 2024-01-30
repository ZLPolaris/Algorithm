import collections
from typing import List


class Solution:
    def pondSizes(self, land: List[List[int]]) -> List[int]:
        # 八个方向的广度优先遍历
        m = len(land)
        n = len(land[0])
        res = []

        def bfs(source):
            queue = collections.deque()
            queue.append(source)
            land[source[0]][source[1]] = 1
            count = 1
            while queue:
                u, v = queue.popleft()
                for row, column in [(u - 1, v), (u + 1, v), (u, v - 1), (u, v + 1), (u - 1, v - 1), (u - 1, v + 1),
                                    (u + 1, v - 1), (u + 1, v + 1)]:
                    if m > row >= 0 and 0 <= column < n and 0 == land[row][column]:
                        land[row][column] = 1
                        queue.append((row, column))
                        count += 1
            return count

        for i in range(m):
            for j in range(n):
                if land[i][j] == 0:
                    res.append(bfs((i, j)))
        return sorted(res)
