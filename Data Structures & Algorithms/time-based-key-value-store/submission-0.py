from collections import defaultdict
from typing import List

class TimeMap:

    def __init__(self):

        self.mapper = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:

        self.mapper[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:

        arr = self.mapper[key]

        l = 0
        r = len(arr) - 1

        res = ""

        while l <= r:

            m = (l + r) // 2

            if arr[m][0] <= timestamp:
                res = arr[m][1]
                l = m + 1
            else:
                r = m - 1

        return res

        
