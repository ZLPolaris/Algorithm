from typing import List


# 使用哈希表实现
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        dic_nums = dict()
        n = len(nums)
        for i in range(n):
            dic_nums[nums[i]] = i

        max_count = 0
        for i in range(n):
            if nums[i] - 1 not in dic_nums:
                count = 1
                k = nums[i] + 1
                while k in dic_nums:
                    count += 1
                    k += 1
                if count > max_count:
                    max_count = count
        return max_count
