class Solution:
    from collections import Counter
    import heapq
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize:
            return False
        cards = Counter(hand)
        minHp = [k for k in cards]
        heapq.heapify(minHp)
        while minHp:
            top = minHp[0]
            if top not in cards:
                return False
            for i in range(top,top+groupSize):
                if i in cards:
                    cards[i] -= 1
                    if cards[i] == 0:
                        _ = heapq.heappop(minHp)
                        del cards[i]
                else: return False

        return True
                



        
        