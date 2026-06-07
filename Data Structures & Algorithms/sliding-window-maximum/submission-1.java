

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // Index for our result array
        
        // Deque will store indices of elements
        Deque<Integer> queue = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            // 1. Remove indices of elements out of the current window's bounds
            if (!queue.isEmpty() && queue.peekFirst() < r - k + 1) {
                queue.pollFirst();
            }

            // 2. Remove indices of all elements smaller than the current element 
            // from the back of the deque
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[r]) {
                queue.pollLast();
            }

            // 3. Add current element's index to the back
            queue.addLast(r);

            // 4. Once our window hits size 'k', the front of the queue is our max
            if (r >= k - 1) {
                result[ri++] = nums[queue.peekFirst()];
            }
        }

        return result;
    }
}
