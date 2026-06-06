

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 1. Build the frequency map for the target string 't'
        Map<Character, Integer> lookupt = new HashMap<>();
        for (char c : t.toCharArray()) {
            lookupt.put(c, lookupt.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> lookups = new HashMap<>();
        int l = 0;
        int have = 0;
        int need = lookupt.size();
        
        // Track the best window: [windowLength, startIdx, endIdx]
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[]{-1, -1};

        // 2. Expand the right pointer
        for (int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);
            lookups.put(curr, lookups.getOrDefault(curr, 0) + 1);

            // If the current character is desired and matches the exact target frequency
            if (lookupt.containsKey(curr) && lookups.get(curr).equals(lookupt.get(curr))) {
                have++;
            }

            // 3. Contract the left pointer when the window is valid
            while (have == need) {
                // Update our result if we found a smaller window
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    result[0] = l;
                    result[1] = r;
                }

                // Pop the leftmost character out of our window
                char leftChar = s.charAt(l);
                lookups.put(leftChar, lookups.get(leftChar) - 1);

                // If removing this character breaks our 'have' requirement, decrement have
                if (lookupt.containsKey(leftChar) && lookups.get(leftChar) < lookupt.get(leftChar)) {
                    have--;
                }
                l++; // Shrink window
            }
        }

        // 4. Return the substring if a valid window was found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}