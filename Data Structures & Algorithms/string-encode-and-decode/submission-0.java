class Solution {

    public static String encode(List<String> strs) {

        if (strs == null) {
            return null;
        }

        if (strs.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // s.length might be 0, but not null, so need to handle later
            sb.append(s.length());
            sb.append('#');

            for (char c : s.toCharArray()) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        if (str == null) {
            return null;
        }

        if (str.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); ) { // 这里不能顺手写 i++，因为 index 的更新下面会手动更新
            int length = Integer.parseInt("" + str.charAt(i));
            StringBuilder sb = new StringBuilder();

            if (length == 0) {
                i = i + 2;
            } else {
                for (int times = 0; times < length; times++) {
                    int start = i + 2 + times;
                    sb.append(str.charAt(start));
                }

                i = i + 2 + length;
            }

            result.add(sb.toString());
        }

        return result;
    }
}
