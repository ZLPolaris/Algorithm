import bisect
import functools
from typing import List


class Solution:
    @staticmethod
    def cmp(elem1, elem2):
        if elem1[0] > elem2[0]:
            return 1
        elif elem1[0] < elem2[0]:
            return -1
        else:
            if elem1[1] > elem2[1]:
                return -1
            elif elem1[1] < elem2[1]:
                return 1
            else:
                return 0
            pass
        pass

    pass

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        envelopes.sort(key=functools.cmp_to_key(Solution.cmp))
        res = [envelopes[0][1]]
        for i in range(1, n):
            if envelopes[i][1] > res[-1]:
                res.append(envelopes[i][1])
                pass
            else:
                index = bisect.bisect_left(res, envelopes[i][1])
                res[index] = envelopes[i][1]
                pass
            pass
        return len(res)
