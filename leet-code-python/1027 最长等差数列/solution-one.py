from typing import List


class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [{} for i in range(n)]
        maxLength = 1
        for i in range(1, n):
            for j in range(0, i):
                d = nums[i] - nums[j]
                dp[i][d] = dp[j].get(d, 1) + 1
                if dp[i][d] > maxLength:
                    maxLength = dp[i][d]
                    pass
                pass
            pass
        print(dp)
        return maxLength

    pass


s = Solution()
print(s.longestArithSeqLength([83, 20, 17, 43, 52, 78, 68, 45]))
