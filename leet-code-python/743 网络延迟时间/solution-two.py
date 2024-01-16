from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = [[float('inf')] * n for _ in range(n)]
        for time in times:
            graph[time[0] - 1][time[1] - 1] = time[2]
            pass

        def dijkstra():
            final = [False] * n
            dist = [float('inf')] * n

            select = k - 1
            dist[select] = 0
            final[select] = True

            maxDist = 0
            minDist = 0
            count = 0
            while select != -1 and count < n:
                if minDist > maxDist:
                    maxDist = minDist

                for j in range(n):
                    if not final[j] and graph[select][j] != float('inf') and dist[select] + graph[select][j] < dist[j]:
                        dist[j] = dist[select] + graph[select][j]
                        pass
                    pass

                minDist = float('inf')
                select = -1
                for j in range(n):
                    if not final[j] and dist[j] < minDist:
                        minDist = dist[j]
                        select = j
                        pass
                    pass
                final[select] = True
                count += 1
                pass
            return -1 if count < n else maxDist

        return dijkstra()
