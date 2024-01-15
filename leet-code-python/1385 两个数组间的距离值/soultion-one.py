from typing import List


class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        m = len(arr1)
        n = len(arr2)
        first = 0
        second = 0
        arr1.sort()
        arr2.sort()
        count = 0
        while first < m and second < n:
            if arr1[first] - arr2[second] > d:
                second += 1
                continue
                pass
            flag = 1
            if arr1[first] - arr2[second] == d:
                flag = 0
                second += 1
                pass
            elif abs(arr1[first] - arr2[second]) < d:
                flag = 0
                pass
            elif arr1[first] - arr2[second] == -d:
                flag = 0
                pass
            first += 1
            count += flag
            pass
        return count + m - first

    pass


s = Solution()
print(s.findTheDistanceValue([4, 5, 8], [10, 9, 1, 8], 2))
