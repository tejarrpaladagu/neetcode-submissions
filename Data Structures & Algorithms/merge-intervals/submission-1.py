class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals: return intervals
        intervals.sort(key = lambda x: x[0])
        out = [intervals[0]]
        for st,end in intervals:
            if st <= out[-1][-1]:
                out[-1] = [out[-1][0],max(end,out[-1][-1])]
            else:
                out.append([st,end])
        return out
        