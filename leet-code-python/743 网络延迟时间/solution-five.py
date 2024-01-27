import collections
import heapq
from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj_list = collections.defaultdict(list)
        for time in times:
            adj_list[time[0] - 1].append((time[1] - 1, time[2]))

        colors = [False] * n
        father = [-1] * n
        dist = [float('inf')] * n

        pq = [(0, k - 1)]
        heapq.heapify(pq)
        dist[k - 1] = 0
        while pq:
            d, u = heapq.heappop(pq)
            if colors[u]:
                continue
            colors[u] = True
            for v, w in adj_list[u]:
                if not colors[v] and dist[v] > dist[u] + w:
                    dist[v] = dist[u] + w
                    father[v] = u
                    heapq.heappush(pq, (dist[v], v))
        res = max(dist)
        return res if res != float('inf') else -1
