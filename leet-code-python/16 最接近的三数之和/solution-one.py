from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        n = len(nums)
        nums.sort()
        res = float('inf')
        for a in range(n - 2):
            if a > 0 and nums[a] == nums[a - 1]:
                continue
                pass
            singleSum = nums[a] + nums[a + 1] + nums[a + 2]
            if singleSum > target:
                if singleSum - target < abs(res - target):
                    res = singleSum
                continue
                pass
            elif singleSum == target:
                return target
            c = n - 1
            for b in range(a + 1, n - 1):
                if b > a + 1 and nums[b] == nums[b - 1]:
                    continue
                    pass
                while b < c and nums[a] + nums[b] + nums[c] > target:
                    c -= 1
                    pass
                if b == c:
                    if nums[a] + nums[b] + nums[b + 1] - target < abs(res - target):
                        res = nums[a] + nums[b] + nums[b + 1]
                    break
                    pass
                if nums[a] + nums[b] + nums[c] == target:
                    return target
                if c == n - 1:
                    if target - (nums[a] + nums[b] + nums[c]) < abs(res - target):
                        res = nums[a] + nums[b] + nums[c]
                    pass
                else:
                    if nums[a] + nums[b] + nums[c] - target < abs(res - target):
                        res = nums[a] + nums[b] + nums[c]
                        pass
                    if nums[a] + nums[b] + nums[c + 1] - target < abs(res - target):
                        res = nums[a] + nums[b] + nums[c + 1]
                    pass
                pass
            pass
        return res
    pass


s = Solution()
print(s.threeSumClosest([-1, 2, 1, -4], 1))
