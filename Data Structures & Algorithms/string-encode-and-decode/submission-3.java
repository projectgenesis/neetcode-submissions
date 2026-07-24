class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            builder.append(String.valueOf(length));
            builder.append("#");
            builder.append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) return List.of();

        int i = 0;
        List<String> result = new ArrayList<>();
        System.out.println("str: " + str);
        while(i < str.length()) {
            int lengthDelimiterPos = str.indexOf("#", i);
            System.out.println("i, lengthDelimiterPos = " + i + ", " + lengthDelimiterPos);
            int length = Integer.parseInt(str.substring(i, lengthDelimiterPos));
            System.out.println("length: " + length);
            String value = str.substring(lengthDelimiterPos + 1, lengthDelimiterPos + 1 + length);
            result.add(value);
            System.out.println("Value: " + value);
            i = lengthDelimiterPos + length + 1;
        }
        return result;
    }
}
