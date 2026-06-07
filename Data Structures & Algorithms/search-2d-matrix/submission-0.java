class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Quick boundary check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int l = 0;
        int r = matrix.length - 1;
        int[] curr = null; // FIXED: Declare 'curr' outside so the whole method can see it

        // Step 1: Binary Search to find the correct row
        while (l <= r) {
            int mid = l + ((r - l) / 2); // FIXED: Added 'int' declaration
            
            // Check if target falls within the range of the current row
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) { // FIXED: typo 'matix'
                curr = matrix[mid];
                break; // FIXED: Must break out of the loop once the row is found!
            }
            else if (target < matrix[mid][0]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        // If 'curr' is still null, it means the target doesn't fit into any row range
        if (curr == null) {
            return false;
        }

        int i = 0;
        int j = curr.length - 1;

        // Step 2: Binary Search within the identified row
        while (i <= j) {
            int mid = i + ((j - i) / 2); // FIXED: Added 'int' declaration
            
            if (curr[mid] == target) {
                return true; // FIXED: Lowercase 'true'
            }
            else if (curr[mid] > target) {
                j = mid - 1; // FIXED: Change 'j', not 'r'
            }
            else {
                i = mid + 1; // FIXED: Change 'i', not 'l'
            }
        }

        return false; // FIXED: Lowercase 'false'
    }
}
