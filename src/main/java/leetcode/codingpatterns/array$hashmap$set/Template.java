package leetcode.codingpatterns.array$hashmap$set;

import java.util.*;

public class Template {

    // Efficient string building
    public String fnI(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }

    public String fnII(char[] arr) {
        return new String(arr).chars()
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    /* ---------------------- Easy ----------------------- */
    // Frequency Count
    // Used in anagrams, subsequence checks, or majority element.
    public Map<Character, Integer> getFreqMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    // Check for Duplicates
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) return true; // add() returns false if already present
        }
        return false;
    }

    // Check for Anagram
    private boolean anagram(String w1, String w2) {
        if (w1.length() != w2.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < w1.length(); i++) {
            freq[w1.charAt(i) - 'a']++;
            freq[w2.charAt(i) - 'a']--;
        }
        for (int f : freq) if (f != 0) return false;
        return true;
    }


    /* ---------------------- Medium ----------------------- */

    // Group Anagrams
    public List<List<String>> groupAnagramsI(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            sb.setLength(0);
            sb.append(chars);
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // Two Sum (HashMap Lookup)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // num -> index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // Subarray Sum Equals K
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // prefix sum = 0 has one count
        int sum = 0, count = 0;

        for (int n : nums) {
            sum += n;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /* ---------------------- Hard ----------------------- */

}
