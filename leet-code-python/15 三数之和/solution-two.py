from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res = []
        for i in range(n):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
                pass
            target = -nums[i]
            right = n - 1
            for left in range(i + 1, n - 1):
                if left > i + 1 and nums[left] == nums[left - 1]:
                    continue
                while left < right and nums[left] + nums[right] > target:
                    right -= 1
                    pass
                if left == right:
                    break
                    pass
                if nums[left] + nums[right] == target:
                    res.append([nums[i], nums[left], nums[right]])
                    pass
                pass
            pass
        return res
