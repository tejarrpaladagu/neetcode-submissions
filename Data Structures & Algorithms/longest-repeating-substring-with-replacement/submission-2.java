

class Solution {
    public int characterReplacement(String s, int k) {
        int maxRepeating = 0;
        int l = 0;
        int result = 0;
        Map<Character, Integer> lookup = new HashMap<>();
        int nonRepeating = 0;

        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            
            // FIXED: Pass the rightChar key directly to getOrDefault
            lookup.put(rightChar, lookup.getOrDefault(rightChar, 0) + 1);
            
            maxRepeating = Math.max(maxRepeating, lookup.get(rightChar));
            nonRepeating = (r - l + 1 - maxRepeating);

            if (nonRepeating > k) {
                char leftChar = s.charAt(l);
                lookup.put(leftChar, lookup.get(leftChar) - 1);
                l++;
            }
            
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}