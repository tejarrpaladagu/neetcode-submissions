class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = []
        ops = operations
        for i in range(0,len(ops)):
            if ops[i] == "+":
                new = stack[-1] + stack[-2]
                stack.append(new)
            elif ops[i] == "D":
                stack.append(2 * stack[-1])
            elif ops[i] == "C":
                stack.pop()
            else:
                stack.append(int(ops[i]))
        return sum(stack)
            
        