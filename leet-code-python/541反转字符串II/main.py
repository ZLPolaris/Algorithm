import math
from typing import List


class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        chars = list(s)
        n = len(chars)
        number = math.ceil(math.ceil(n / k) / 2)
        for i in range(0, number - 1):
            self.reverSingleStr(chars, 2 * k * i, 2 * k * i + k - 1)
            pass
        if 2 * (number - 1) * k + k - 1 >= n:
            self.reverSingleStr(chars, 2 * (number - 1) * k, n - 1)
            pass
        else:
            self.reverSingleStr(chars, 2 * (number - 1) * k, 2 * (number - 1) * k + k - 1)
            pass
        return "".join(chars)
        pass

    def reverSingleStr(self, chars: List[str], left, right) -> None:
        while left < right:
            chars[left], chars[right] = chars[right], chars[left]
            left += 1
            right -= 1
            pass
        pass

    pass


solution = Solution()
print(solution.reverseStr("abcd", 2))
