

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>(); // 

        for (String t : tokens) {
            // Check for operators using .equals()
            if (t.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } 
            else if (t.equals("-")) {
                // Pop the right operand first, then the left operand
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } 
            else if (t.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } 
            else if (t.equals("/")) {
                // Pop the right operand first, then the left operand
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b); // Java integer division automatically truncates toward zero
            } 
            else {
                // If it's not an operator, it's a number token. Parse and push it.
                stack.push(Integer.parseInt(t));
            }
        }
        
        // The final remaining element is our total evaluation result
        return stack.pop();
    }
}