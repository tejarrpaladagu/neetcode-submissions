class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>minHeap = new PriorityQueue<>();
        for(int stone:stones){
            minHeap.offer(-stone);
        }

        while (minHeap.size() > 1){
            int a = -(minHeap.poll());
            int b = -(minHeap.poll());
            int c = a-b;
            minHeap.offer(-c);
        }
        minHeap.offer(0);

        return Math.abs(minHeap.poll());
        
    }
}
