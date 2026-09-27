class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }

        if (s.length() < 2) {
            return 1;
        }

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        if (isValid(s.substring(0, 2))) {
            if (isValid(s.substring(0, 1)) && isValid(s.substring(1, 2))) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        } else {
            if (isValid(s.substring(0, 1)) && isValid(s.substring(1, 2))) {
                dp[1] = 1;
            } else {
                dp[1] = 0;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            int result1 = 0;
            int result2 = 0;

            if (isValid(s.substring(i, i + 1))) {
                result1 = dp[i - 1];
            }

            if (isValid(s.substring(i - 1, i + 1)))  {
                result2 = dp[i - 2];
            }

            dp[i] = result1 + result2;
        }

        return dp[s.length() - 1];
    }

    private boolean isValid(String s) {
        if (s.startsWith("0")) {
            return false;
        }

        if (s.length() == 1) {
            return true;
        }

        if (s.length() == 2) {
            return Integer.parseInt(s) <= 26;
        }

        return false;
    }
}
