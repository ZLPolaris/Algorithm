from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adjMatrix = [[-1] * n for _ in range(n)]
        for flight in flights:
            adjMatrix[flight[0]][flight[1]] = flight[2]
            pass
        dp = [i for i in adjMatrix[src]]
        dp[src] = 0
        for t in range(2, k + 2):
            tmp = dp.copy()
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
            print(tmp)
            dp = tmp
            pass
        return dp[dst]
