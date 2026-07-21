class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length ==1) return List.of(List.of(strs[0]));
        List<List<String>> results = new ArrayList<>();
        Set<String> found = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            if (found.contains(strs[i])) continue;
            List<String> anagrams = new ArrayList<>();
            anagrams.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    anagrams.add(strs[j]);
                    found.add(strs[i]);
                    found.add(strs[j]);
                }
            }
            results.add(anagrams);
        }
        return results;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            mapA.put(a.charAt(i), mapA.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int j = 0; j < b.length(); j++) {
            mapB.put(b.charAt(j), mapB.getOrDefault(b.charAt(j), 0) + 1);
        }
        return mapA.equals(mapB);
    }
}
