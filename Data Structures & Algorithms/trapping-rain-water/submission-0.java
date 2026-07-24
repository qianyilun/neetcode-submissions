class Solution {
    public int trap(int[] height) {
        int[] leftMaxOfIndex = new int[height.length];
        int[] rightMaxOfIndex = new int[height.length];
        
        int tempMax = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            tempMax = Math.max(tempMax, h);
            
            leftMaxOfIndex[i] = tempMax;
        }
        
        tempMax = 0;
        for (int i = height.length - 1; i >=0; i--) {
            int h = height[i];
            tempMax = Math.max(tempMax, h);
            
            rightMaxOfIndex[i] = tempMax;
        }
        
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int heightOfWall = Math.min(leftMaxOfIndex[i], rightMaxOfIndex[i]);
            
            int water = heightOfWall - height[i];
            
            if (water > 0) {
                result += water;
            }
        }
        
        return result;
    }
}
