class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        StringBuilder builder = new StringBuilder();
        builder.append(uuidStr);
        for (String str : strs) {
            if (str.equals("")) builder.append("zEMPTYz");
            else builder.append(str);
            builder.append(uuidStr);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) return List.of();
        String uuidStr = str.substring(0, 36);
        String[] strArray = str.substring(36).split(uuidStr);
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals("zEMPTYz")) strArray[i] = "";
        }
        return Arrays.asList(strArray);
    }
}
