from typing import List


# class Solution:
#     def removeElement(self, nums: List[int], val: int) -> int:
#         n = len(nums)
#         i = - 1
#         j = 0
#         while j < n:
#             if nums[j] != val:
#                 if i + 1 != j:
#                     nums[i + 1] = nums[j]
#                     pass
#                 i += 1
#                 pass
#             j += 1
#             pass
#         return i + 1
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        n = len(nums)
        # 左侧合格的下一个，左侧待检测的第一个
        left = 0
        # 右侧待检测的数据
        right = n - 1
        # 当左指针大于右指针，代表左侧都检测过了，右侧也检测过了，相等时候不行
        while left <= right:
            if nums[left] == val:
                nums[left] = nums[right]
                right -= 1
                pass
            else:
                left += 1
                pass
            pass
        return left

