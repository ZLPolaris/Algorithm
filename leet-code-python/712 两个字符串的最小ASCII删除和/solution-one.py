class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m = len(s1)
        n = len(s2)
        count1 = 0
        num1 = []
        for char in s1:
            num1.append(ord(char))
            count1 += ord(char)
            pass

        count2 = 0
        num2 = []
        for char in s2:
            num2.append(ord(char))
            count2 += ord(char)
            pass
        dp = [0] * (n + 1)
        for i in range(1, m + 1):
            front = dp[0]
            for j in range(1, n + 1):
                if num1[i - 1] == num2[j - 1]:
                    front, dp[j] = dp[j], front + num1[i - 1]
                    pass
                else:
                    front, dp[j] = dp[j], max(dp[j], dp[j - 1])
                    pass
                pass
            pass
        return count1 + count2 - dp[n] * 2
