from typing import List


class Solution:
    def diStringMatch(self, s: str) -> List[int]:
        n = len(s)
        small = 0
        big = n
        nums = [0] * (n + 1)
        i = 0
        for item in s:
            if item == "I":
                nums[i] = small
                small += 1
                pass
            else:
                nums[i] = big
                big -= 1
                pass
            i += 1
            pass
        nums[i] = small
        return nums
