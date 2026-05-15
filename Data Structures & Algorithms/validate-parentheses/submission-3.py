class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(0,len(s)):
            if s[i] == "]":
                if stack and stack[-1] == "[":
                    stack.pop()
                else:
                    return False
            elif s[i] == "}":
                if stack and stack[-1] == "{":
                    stack.pop()
                else:
                    return False
            elif s[i] == ")":
                if stack and stack[-1] == "(":
                    stack.pop()
                else:
                    return False
            else:
                stack.append(s[i])
        return True if not stack else False
            
        