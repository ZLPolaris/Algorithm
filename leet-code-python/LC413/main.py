from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        front = self.getSingleLength(nums, 0)
        number = front
        for i in range(1, len(nums)):
            if front <= 1:
                front = self.getSingleLength(nums, i)
                pass
            else:
                front = front - 1
                pass
            number += front
        return number

    def getSingleLength(self, nums: List[int], k) -> int:
        length = 0
        for i in range(k + 2, len(nums)):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                length += 1
            else:
                break
                pass
            pass
        return length


if __name__ == '__main__':
    solution = Solution()
    print(solution.numberOfArithmeticSlices([1, 2, 3, 4]))
