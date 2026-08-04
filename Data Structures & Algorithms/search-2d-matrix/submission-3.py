class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = 0
        n = len(matrix)-1
        curr = matrix[0]

        while(m <= n):
            mid = (m+n)//2
            if matrix[mid][0] <= target <= matrix[mid][-1]:
                curr = matrix[mid]
                break

            elif matrix[mid][0] > target:
                n = mid - 1

            else:
                m = mid + 1

        l = 0
        r = len(curr) - 1
        while(l <= r):
            mid = (l+r)//2
            if curr[mid] == target:
                return True

            elif curr[mid] > target:
                r = mid - 1

            else:
                l = mid + 1

        return False

        