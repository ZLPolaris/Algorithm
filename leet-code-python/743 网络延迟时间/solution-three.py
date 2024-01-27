from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        # 使用bellman-ford算法
        dist = [float('inf')] * n
        dist[k - 1] = 0

        for i in range(n - 1):
            flag = False
            for time in times:
                if dist[time[1] - 1] > dist[time[0] - 1] + time[2]:
                    dist[time[1] - 1] = dist[time[0] - 1] + time[2]
                    flag = True
            if not flag:
                break
        res = max(dist)
        return res if res < float('inf') else -1
