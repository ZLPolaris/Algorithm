from typing import List


class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1] * n
        dp[0] = 1
        res = [1] * n
        max_index = 0
        count = 1
        for i in range(1, n):
            for j in range(0, i):
                if nums[j] < nums[i]:
                    if dp[j] + 1 > dp[i]:
                        dp[i] = dp[j] + 1
                        res[i] = res[j]
                        pass
                    elif dp[j] + 1 == dp[i]:
                        res[i] += res[j]
                        pass
                    pass
                pass
            if dp[max_index] < dp[i]:
                max_index = i
                count = res[i]
                pass
            elif dp[max_index] == dp[i]:
                count += res[i]
            pass
        # print(dp)
        # print(res)
        # print(max_index)
        return count
    pass


s = Solution()
print(s.findNumberOfLIS([1, 2, 4, 3, 5, 4, 7, 2]))
