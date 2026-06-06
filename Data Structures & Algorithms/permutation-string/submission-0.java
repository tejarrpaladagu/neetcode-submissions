

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> lookup1 = new HashMap<>();
        // FIX 1 & 2: Converted to char array and fixed variable name to lookup1
        for (char s : s1.toCharArray()) {
            lookup1.put(s, lookup1.getOrDefault(s, 0) + 1);
        }

        Map<Character, Integer> lookup2 = new HashMap<>();
        int l = 0;
        int window = s1.length();

        for (int r = 0; r < s2.length(); r++) {
            char rightChar = s2.charAt(r);
            // FIX 3: Corrected getOrDefault syntax
            lookup2.put(rightChar, lookup2.getOrDefault(rightChar, 0) + 1);

            // If our window size exceeds s1's length, squeeze the left side out
            if (r - l + 1 > window) {
                char leftChar = s2.charAt(l);
                if (lookup2.get(leftChar) == 1) {
                    lookup2.remove(leftChar); // Clean up the key if count drops to 0
                } else {
                    lookup2.put(leftChar, lookup2.get(leftChar) - 1);
                }
                l++; // Move left pointer up
            }

            // FIX 3 & 5: Used standard .equals() and verified window is filled
            if (r - l + 1 == window && lookup2.equals(lookup1)) {
                return true;
            }
        }

        return false; // FIX: Java uses lowercase 'false'
    }
}