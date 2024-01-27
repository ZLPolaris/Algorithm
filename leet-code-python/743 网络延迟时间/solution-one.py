import collections
from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = [[float('inf')] * n for _ in range(n)]
        for time in times:
            graph[time[0] - 1][time[1] - 1] = time[2]
            pass

        def dijkstra() -> int:
            select = k - 1
            dist = [float('inf')] * n
            final = [False] * n
            dist[select] = 0
            maxDist = -1
            for i in range(n):
                minDist = float('inf')
                select = -1
                for j in range(n):
                    if not final[j] and dist[j] < minDist:
                        minDist = dist[j]
                        select = j
                        pass
                    pass
                if minDist > maxDist:
                    maxDist = minDist
                final[select] = True
                for j in range(n):
                    if not final[j] and graph[select][j] != float('inf') and dist[select] + graph[select][j] < dist[j]:
                        dist[j] = dist[select] + graph[select][j]
                        pass
                    pass
            return -1 if maxDist == float('inf') else maxDist

        return dijkstra()
        pass
