
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build the frequency map (using the clean getOrDefault method)
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int num : nums) {
            lookup.put(num, lookup.getOrDefault(num, 0) + 1);
        }
        
        // 2. Initialize the array of lists (buckets)
        // Size is nums.length + 1 to handle the case where one element fills the array
        List<Integer>[] arrayofLists = new ArrayList[nums.length + 1];
        for (int i = 0; i < arrayofLists.length; i++) {
            arrayofLists[i] = new ArrayList<>();
        }
        
        // 3. Populate buckets: index is the FREQUENCY, list holds the NUMBERS
        lookup.forEach((key, value) -> {
            arrayofLists[value].add(key);
        });
        
        // 4. Gather the top k elements from right to left (highest frequency first)
        int[] output = new int[k];
        int index = 0;
        
        for (int i = arrayofLists.length - 1; i >= 0; i--) {
            if (!arrayofLists[i].isEmpty()) {
                for (int num : arrayofLists[i]) {
                    if (index < k) {
                        output[index++] = num;
                    } else {
                        break;
                    }
                }
            }
            if (index == k) break; // Optimization: stop early once we have k elements
        }
        
        return output;
    }
}
