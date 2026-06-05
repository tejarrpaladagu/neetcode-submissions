class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> lookup = new HashSet<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char currentVal = board[i][j];
                
                // 1. CRITICAL: Skip empty slots
                if (currentVal == '.') {
                    continue;
                }
                
                // 2. Create completely unique, non-colliding keys
                String rowKey = "row " + i + " has " + currentVal;
                String colKey = "col " + j + " has " + currentVal;
                String boxKey = "box " + (i / 3) + "-" + (j / 3) + " has " + currentVal;
                
                // 3. Check if ANY of these keys already exist
                if (lookup.contains(rowKey) || lookup.contains(colKey) || lookup.contains(boxKey)) {
                    return false;
                }
                
                // 4. If safe, add them all to our tracker
                lookup.add(rowKey);
                lookup.add(colKey);
                lookup.add(boxKey);
            }
        }
        
        return true;
    }
}
