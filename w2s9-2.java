import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : frequency.keySet()) {
            int freq = frequency.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }
        int[] result = new int[k];
        int index = 0;
        for (int freq = buckets.length - 1; freq >= 0; freq--) {
            if (buckets[freq] != null) {
                for (int num : buckets[freq]) {
                    result[index] = num;
                    index++;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
