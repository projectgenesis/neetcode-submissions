class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequenciesMap = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        int[] results = new int[k];

        for (int num : nums) {
            int frequency = frequenciesMap.getOrDefault(num, 0) + 1;
            frequenciesMap.put(num, frequency);
        }
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer,Integer> entry : frequenciesMap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int index = 0;
        for (int j = freq.length - 1; index < k && j > 0; j--) {
            for (int n : freq[j]) {
                results[index++] = n;
                if (index == k) {
                    return results;
                }
            }
        }
        return results;
    }
}
