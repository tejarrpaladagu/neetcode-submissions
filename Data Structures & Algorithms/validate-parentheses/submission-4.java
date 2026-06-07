class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> lookup = Map.of( ']', '[',')', '(','}', '{');
        Deque<Character>stack = new ArrayDeque<>();
        for(char curr:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == lookup.get(curr)){
                stack.pop();
            }
            else{
            stack.push(curr);}

        }
        return stack.isEmpty();
        
        
    }
}
