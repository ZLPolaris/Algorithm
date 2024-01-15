from typing import List


class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        n = len(nums)
        oddPointer = 1
        evenPointer = 0
        while oddPointer < n and evenPointer < n - 1:
            while oddPointer < n and nums[oddPointer] & 1 == 1:
                oddPointer += 2
                pass
            while evenPointer < n - 1 and nums[evenPointer] & 1 == 0:
                evenPointer += 2
                pass
            print(evenPointer, oddPointer)
            if oddPointer < n and evenPointer < n - 1:
                nums[oddPointer], nums[evenPointer] = nums[evenPointer], nums[oddPointer]
                oddPointer += 2
                evenPointer += 2
                pass

            pass
        return nums
