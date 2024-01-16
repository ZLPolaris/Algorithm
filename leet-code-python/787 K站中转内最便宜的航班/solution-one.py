import collections
from typing import List


# 尝试单源最短路径算法求解，难以实现
class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = [[float('inf')] * n for _ in range(n)]
        for flight in flights:
            graph[flight[0]][flight[1]] = flight[2]
            pass

        def dijkstra():
            final = [False] * n
            preNumber = [1] * n
            dist = [float('inf')] * n
            for i in range(n):
                dist[i] = graph[src][i]
                pass

            dist[src] = 0
            final[src] = True
            preNumber[src] = 0
            for i in range(n):
                minDist = float('inf')
                select = -1
                for j in range(n):
                    if not final[j] and dist[j] < minDist:
                        minDist = dist[j]
                        select = j
                        pass
                    pass
                if select == -1:
                    break
                final[select] = True
                print(dist)
                for j in range(n):
                    if not final[j] and graph[select][j] != float('inf') and graph[select][j] + dist[select] < dist[
                        j]:
                        if j != src:
                            dist[j] = graph[select][j] + dist[select]
                            preNumber[j] = preNumber[select] + 1
                            pass
                        else:
                            if preNumber[j] <= k:
                                dist[j] = graph[select][j] + dist[select]
                    pass
                pass
            return dist[dst]

        res = dijkstra()
        return res if res != float('inf') else -1
