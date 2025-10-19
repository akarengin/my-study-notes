package leetcode.trendyol.hiringday;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{i, map.get(complement)};
      }
      map.put(nums[i], i);
    }
    return nums;
  }

  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(nums[i], nums[i] + max);
      res = Math.max(res, max);
    }
    return res;
  }

  /*
   * Approach:
   * Calculate prefixSum for all possible sums starting from zero
   * Calculate difference between adjacent prefixes
   * Check whether there's k - sum for each sum
   * */
  public int subarraySum(int[] nums, int k) {

    return k;
  }

  public boolean isPalindrome(String s) {
    String nonAlphanumeric = s.replaceAll("[^a-zA-Z0-9]", "");
    String lowerCase = nonAlphanumeric.toLowerCase();
    StringBuilder sb = new StringBuilder(lowerCase);
    return lowerCase.equals(sb.reverse().toString());
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
      freq[t.charAt(i) - 'a']--;
    }
    for (int i : freq) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }

  public int firstUniqChar(String s) {
//        Set<Character> set = new HashSet<>();
//        for (char ch : s.toCharArray()) {
//            set.add(ch);
//        }
//        for
////        return (int) Arrays.stream(s.split("")).distinct().findFirst().orElse(deafult);
    return 0;
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    Arrays.stream(strs).forEach(s -> {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      sb.setLength(0);
      sb.append(chars);
      String key = sb.toString();
      map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    });
    return new ArrayList<>(map.values());
  }

  public boolean isValid(String s) {

    return false;
  }

  public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[low] <= nums[mid]) {
        if (nums[low] <= target && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }

}


