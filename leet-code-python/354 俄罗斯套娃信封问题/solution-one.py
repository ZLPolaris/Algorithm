import bisect
import functools
from typing import List


class Solution:

    @staticmethod
    def cmp(elem1, elem2):
        if elem1[0] > elem2[0]:
            return 1
        elif elem1[0] < elem2[0]:
            return -1
        else:
            if elem1[1] > elem2[1]:
                return -1
            elif elem1[1] < elem2[1]:
                return 1
            else:
                return 0
            pass
        pass

    pass

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        envelopes.sort(key=functools.cmp_to_key(Solution.cmp))
        dp = [1] * n
        res = 1
        for i in range(1, n):
            for j in range(0, i):
                if envelopes[j][1] < envelopes[i][1] and dp[j] + 1 > dp[i]:
                    dp[i] = dp[j] + 1
            if dp[i] > res:
                res = dp[i]
                pass
        pass
        return res

    pass


s = Solution()
print(s.maxEnvelopes([[4, 5], [4, 6], [6, 7], [2, 3], [1, 1]]))
nums = [5, 6]
print(bisect.bisect_left(nums, 1))
