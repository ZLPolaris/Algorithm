
from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        if n == 1:
            return matrix[0][0]
        dp = matrix[0]
        print(dp)
        res = 0
        for i in range(1, n):
            front = dp[0]
            dp[0] = min(dp[0], dp[1]) + matrix[i][0]
            res = dp[0]
            for j in range(1, n):
                tmp = dp[j]
                dp[j] = min(front, dp[j]) + matrix[i][j]
                front = tmp
                if j + 1 < n:
                    dp[j] = min(dp[j], dp[j + 1] + matrix[i][j])
                    pass
                if i == n - 1 and dp[j] < res:
                    res = dp[j]
                pass
            print(dp)
            pass
        return res
