import bisect
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        left = 0
        right = n - 1
        res = []
        while left < right and nums[left] <= 0:
            target = - (nums[left] + nums[right])
            index = bisect.bisect_left(nums, target, left + 1, right)
            if index == right:
                i = left
                while i < n and nums[i] == nums[left]:
                    i += 1
                    pass
                left = i
                right = n - 1
                continue
                pass
            if (left + 1) <= index <= (right - 1) and nums[index] == target:
                res.append([nums[left], target, nums[right]])
                pass
            i = right
            while i >= 0 and nums[i] == nums[right]:
                i -= 1
                pass
            right = i
            pass
        return res

    pass


s = Solution()
print(s.threeSum([0, 1, 1]))

