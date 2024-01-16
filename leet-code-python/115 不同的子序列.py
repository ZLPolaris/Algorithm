class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        m = len(s)
        n = len(t)
        dp = [0] * (n + 1)
        dp[0] = 1
        print(dp)
        for i in range(1, m + 1):
            front = dp[0]
            for j in range(1, n + 1):
                if s[i - 1] == t[j - 1]:
                    front, dp[j] = dp[j], front + dp[j]
                    pass
                else:
                    front = dp[j]
                    pass
                pass
            pass
        return dp[n]


s = Solution()
print(s.numDistinct("babgbag", "bag"))
