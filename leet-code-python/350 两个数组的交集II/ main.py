from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        n1 = len(nums1)
        n2 = len(nums2)
        first = 0
        second = 0
        res = []
        while first < n1 and second < n2:
            if nums1[first] == nums2[second]:
                res.append(nums1[first])
                first += 1
                second += 1
                pass
            elif nums1[first] < nums2[second]:
                first += 1
                pass
            else:
                second += 1
                pass
            pass
        return res
