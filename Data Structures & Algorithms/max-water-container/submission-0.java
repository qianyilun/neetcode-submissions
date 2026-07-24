class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        
        int result = 0;
        
        while (left < right) {
            int heightLeft = heights[left];
            int heightRight = heights[right];
            int area = Math.min(heightLeft, heightRight) * (right - left);
            
            result = Math.max(result, area);
            
            if (heightLeft > heightRight) {
                right--;    
            } else {
                left++;
            }
        }
        
        return result;
    }
}
