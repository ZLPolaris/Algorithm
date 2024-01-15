from typing import List


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        first = n - 2
        while first >= 0 and nums[first] >= nums[first + 1]:
            first -= 1
            pass
        print(first)
        if first < 0:
            return nums.reverse()
        else:
            second = n - 1
            while nums[second] <= nums[first]:
                second -= 1
                pass
            print(second)
            nums[first], nums[second] = nums[second], nums[first]
            left = first + 1
            right = n - 1
            while left < right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1
                pass
            pass
        pass
