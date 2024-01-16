class Solution:
    def minInsertions(self, s: str) -> int:
        n = len(s)
        dp = [[0] * n for i in range(n)]
        for i in range(1, n):
            for j in range(0, n - i):
                if s[j] == s[j + i]:
                    dp[j][j + i] = dp[j + 1][j + i - 1]
                    pass
                else:
                    dp[j][j + i] = 1 + min(dp[j + 1][j + i], dp[j][j + i - 1])
                    pass
                pass
            pass
        return dp[0][n - 1]
