class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        out = []
        for i in range(len(intervals)):
            if newInterval[-1] < intervals[i][0]: #before
                out.append(newInterval)
                return out + intervals[i:]
            elif newInterval[0]> intervals[i][-1]:
                out.append(intervals[i])
            else:
                newInterval = [min(intervals[i][0],newInterval[0]),max(intervals[i][-1],newInterval[-1])]
        out.append(newInterval)
        return out
            

               
                

