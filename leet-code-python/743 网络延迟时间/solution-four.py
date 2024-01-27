import collections
from typing import List


# 使用邻接矩阵 一个for循环
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = [[float('inf')] * n for _ in range(n)]
        for time in times:
            graph[time[0] - 1][time[1] - 1] = time[2]

        father = [-1] * n
        dist = [float('inf')] * n
        colors = [False] * n

        # 使用邻接表
        dist[k - 1] = 0
        colors[k - 1] = True
        min_index = k - 1
        for i in range(n - 1):
            front_min_index = min_index
            min_index = - 1
            min_dist_select = float('inf')
            for v in range(n):
                if colors[v]:
                    continue
                if dist[v] > dist[front_min_index] + graph[front_min_index][v]:
                    dist[v] = dist[front_min_index] + graph[front_min_index][v]
                if dist[v] < min_dist_select:
                    min_index = v
                    min_dist_select = dist[v]
            if min_index == -1:
                break
            colors[min_index] = True
            father[min_index] = front_min_index
        res = max(dist)
        return res if res != float('inf') else -1
