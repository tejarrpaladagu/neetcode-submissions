

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. Key must be List<Integer>, not a primitive int[] array
        Map<List<Integer>, List<String>> lookup = new HashMap<>();
        
        for (String str : strs) {
            int[] ref = new int[26];
            
            // 2. Correct Java loop syntax and character indexing
            for (int i = 0; i < str.length(); i++) {
                ref[str.charAt(i) - 'a']++;
            }
            
            // 3. Convert the primitive array to a List<Integer> so HashMap can use it as a valid key
            List<Integer> mapper = new ArrayList<>();
            for (int count : ref) {
                mapper.add(count);
            }
            
            // 4. Use proper Map methods (.containsKey, .get, .put) instead of bracket notation
            if (lookup.containsKey(mapper)) {
                lookup.get(mapper).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                lookup.put(mapper, newList);
            }
        }
        
        // 5. Return all the grouped values as a List of Lists
        return new ArrayList<>(lookup.values());
    }
}