import sys
from typing import List


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxVal = max(nums)
        total = [0] * (maxVal + 1)
        for val in nums:
            total[val] += val
            pass
        first = total[0]
        second = max(total[0], total[1])
        res = second
        for i in range(2, maxVal + 1):
            res = max(first + total[i], second)
            first, second = second, res
            pass
        return res
    pass

