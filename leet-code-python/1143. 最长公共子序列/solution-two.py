class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m = len(text1)
        n = len(text2)
        dp = [0] * (n + 1)
        for i in range(1, m + 1):
            front = dp[0]
            for j in range(1, n + 1):
                if text1[i - 1] == text2[j - 1]:
                    front, dp[j] = dp[j], front + 1
                    pass
                else:
                    front, dp[j] = dp[j], max(dp[j], dp[j - 1])
                    pass
                pass
            pass
        return dp[n]
