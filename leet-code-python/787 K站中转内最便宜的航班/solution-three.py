import sys
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adjMatrix = [[-1] * n for _ in range(n)]
        for flight in flights:
            adjMatrix[flight[0]][flight[1]] = flight[2]
            pass
        # 初始化为 恰好经过一次航班的最便宜价格
        dp = [i for i in adjMatrix[src]]
        minDst = dp[dst]
        for t in range(2, k + 2):
            tmp = [-1] * n
            for i in range(n):
                for j in range(n):
                    if dp[j] != -1 and adjMatrix[j][i] != -1:
                        if tmp[i] == -1:
                            tmp[i] = dp[j] + adjMatrix[j][i]
                            pass
                        else:
                            tmp[i] = min(tmp[i], dp[j] + adjMatrix[j][i])
                            pass
                        pass
                    pass
                pass
            if minDst == -1:
                minDst = tmp[dst]
                pass
            elif tmp[dst] != -1:
                minDst = min(minDst, tmp[dst])
            dp = tmp
            pass
        return minDst
