from typing import List


class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        end = 0
        i = 0
        n = len(nums)
        while i < n:
            if not (nums[i] & 1):
                if end != i:
                    nums[i], nums[end] = nums[end], nums[i]
                    pass
                end += 1
                pass
            i += 1
            pass
        return nums
