class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            // While current temperature is hotter than the day on top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int poppedIndex = stack.pop();
                
                // CRITICAL FIX: Save the day difference exactly where it belongs!
                result[poppedIndex] = i - poppedIndex; 
            }
            
            // Every day's index must be pushed onto the stack to wait for a warmer day
            stack.push(i);
        }
        
        return result;
    }
}