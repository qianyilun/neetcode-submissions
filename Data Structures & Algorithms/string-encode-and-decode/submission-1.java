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
            sb.append(s);
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
        for (int i = 0; i < str.length();) { // 这里不能顺手写 i++，因为 index 的更新下面会手动更新
            // find length
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            String lengthStr = str.substring(i, j);
            int length = Integer.parseInt(lengthStr);

            // update pointers
            int start = j + 1;
            int end = start + length;
            String item = str.substring(start, end);
            result.add(item);

            // update index
            i = end;
        }

        return result;
    }
}
