class Solution {
    public boolean isPalindrome(String s) {
        // edge case
        if (s == null || s.isEmpty()) {
            return true;
        }
         s = s.toLowerCase();
         // general
        int left = 0, right = s.length() - 1;
         while (left <= right) {
            while (left <= right && !isChar(left, s)) {
                left++;
            }
             while (left <= right && !isChar(right, s)) {
                right--;
            }
             if (left <= right && !isSame(left, right, s)) {
                return false;
            }
            
            left++;
            right--;
        }
         return true;
    }
     private boolean isChar(int index, String s) {
        char c = s.charAt(index);
        return (c >= 'a' && c <= 'z')|| (c >= '0' && c <= '9');
    }
     private boolean isSame(int index1, int index2, String s) {
        return s.charAt(index1) == s.charAt(index2);
    }

}
