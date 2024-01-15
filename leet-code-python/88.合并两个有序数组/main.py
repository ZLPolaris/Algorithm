from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # nums1 右侧待排序
        i = m - 1
        # nums2 左侧待排序
        j = n - 1

        while j >= 0 and i >= 0:
            if nums1[i] <= nums2[j]:
                nums1[i + j + 1] = nums2[j]
                j -= 1
                pass
            else:
                nums1[i + j + 1] = nums1[i]
                i -= 1
                pass
            pass
        while j >= 0:
            nums1[i + j + 1] = nums2[j]
            j -= 1
            pass


