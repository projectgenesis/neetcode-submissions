class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> results = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            List<String> anagrams = results.getOrDefault(sortedStr, new ArrayList<>());
            anagrams.add(str);
            results.put(sortedStr, anagrams);
        }
        return new ArrayList<>(results.values());
    }
}
