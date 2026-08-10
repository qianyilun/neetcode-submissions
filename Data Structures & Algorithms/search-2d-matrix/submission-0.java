class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // covert 2d to 1d
        int lo = 0, hi = matrix[0].length * matrix.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int convertedX = mid % matrix[0].length;
            int convertedY = mid / matrix[0].length;
            
            if (matrix[convertedY][convertedX] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        if (lo < matrix[0].length * matrix.length && matrix[lo / matrix[0].length][lo % matrix[0].length] == target) {
            return true;
        }
        
        return false;
    }
}
