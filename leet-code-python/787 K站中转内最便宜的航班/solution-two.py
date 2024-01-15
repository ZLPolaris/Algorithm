import sys
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = [[sys.maxsize] * n for _ in range(n)]
        for flight in flights:
            graph[flight[0]][flight[1]] = flight[2]
            pass
        dp = [i for i in graph[src]]
        minDst = graph[src][dst]
        for t in range(2, k + 2):
            tmp = [0] * n
            for i in range(n):
                tmp[i] = sys.maxsize
                for j in range(n):
                    if graph[j][i] != sys.maxsize and dp[j] != sys.maxsize:
                        tmp[i] = min(tmp[i], dp[j] + graph[j][i])
                        pass
                    pass
                pass
            if tmp[dst] < minDst:
                minDst = tmp[dst]
            dp = tmp
            print(dp)
            pass
        return minDst if minDst != sys.maxsize else -1
