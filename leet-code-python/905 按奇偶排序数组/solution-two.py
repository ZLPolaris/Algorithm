from typing import List


class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        n = len(nums)
        left = 0
        right = n - 1
        while left < right:
            while left < right and nums[left] & 1 == 0:
                left += 1
                pass
            while left < right and nums[right] & 1 == 1:
                right -= 1
                pass
            if left < right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1
                pass
            pass
        return nums