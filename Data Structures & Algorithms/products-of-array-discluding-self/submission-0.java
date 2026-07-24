class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 1;
        int[] postfix = new int[nums.length + 1];
        postfix[postfix.length - 1] = 1;

        // set values
        int prefixSum = 1;
        int postfixSum = 1;

        for (int i = 0; i < nums.length; i++) {
            prefixSum *= nums[i];
            prefix[i + 1] = prefixSum;
        }

        for (int i = nums.length - 1;i > 0; i--) {
            postfixSum *= nums[i];
            postfix[i] = postfixSum;
        }

        // product
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * postfix[i + 1];
        }

        return result;
    }
}  
