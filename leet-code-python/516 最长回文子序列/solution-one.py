class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        dp = [[0] * n for i in range(n)]
        for i in range(0, n):
            dp[i][i] = 1
            pass
        for i in range(1, n):
            for j in range(0, n - i):
                dp[j][j + i] = max(dp[j + 1][j + i], dp[j][j + i - 1])
                if s[j] == s[j + i]:
                    dp[j][j + i] = max(dp[j][j + i], dp[j + 1][j + i - 1] + 2)
                    pass
                pass
            pass
        return dp[0][n - 1]
        pass

    pass


s = Solution()
print(s.longestPalindromeSubseq("cbbd"))
