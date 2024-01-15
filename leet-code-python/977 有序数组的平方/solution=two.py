from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        left = 0
        right = n - 1
        res = [0] * n
        i = n - 1
        while left <= right:
            if abs(nums[left]) > nums[right]:
                res[i] = nums[left] * nums[left]
                left += 1
                pass
            else:
                res[i] = nums[right] * nums[right]
                right -= 1
                pass
            i -= 1
            pass
        return res
