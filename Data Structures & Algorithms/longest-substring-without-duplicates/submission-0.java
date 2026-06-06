class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> lookup = new HashSet<>();

        int l = 0;
        int r = 0;

        while (r < s.length()){
            while(lookup.contains(s.charAt(r))){
                lookup.remove(s.charAt(l));
                l++;
            }
            if(!lookup.contains(s.charAt(r))){
                lookup.add(s.charAt(r));
                r++;
                result = Math.max(result,r-l);
            }
        }
        return result;
        
    }
}
