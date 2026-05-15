"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        oldTonew = {None:None}
        dummy = head

        while dummy:
            oldTonew[dummy] = Node(dummy.val)
            dummy = dummy.next

        dummy = head
        while dummy:
            copy = oldTonew[dummy]
            copy.next = oldTonew[dummy.next]
            copy.random = oldTonew[dummy.random]
            dummy = dummy.next

        return oldTonew[head]


        