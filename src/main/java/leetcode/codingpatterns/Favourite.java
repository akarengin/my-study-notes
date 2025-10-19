package leetcode.codingpatterns;

import java.util.*;
import java.util.stream.IntStream;

public class Favourite {

    public static void main(String[] args) {
        Favourite favourite = new Favourite();
        // Test twoSum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = favourite.twoSum(nums, target);
        System.out.println("Two Sum: " + Arrays.toString(result));

        // Test isAnagram
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Is Anagram: " + favourite.isAnagramI(s, t));

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = favourite.groupAnagrams(input);
        System.out.println("Group Anagrams: " + resultList);

        // Test productExceptSelf
        int[] nums2 = {1, 2, 3, 4};
        int[] result2 = favourite.productExceptSelfI(nums2);
        System.out.println("\nTesting productExceptSelf:");
        System.out.println("Input array: " + Arrays.toString(nums2));
        System.out.println("Result: " + Arrays.toString(result2) + " (Expected: [24, 12, 8, 6])");
    }

    /*
        Approach:
        Use a map to store the complement of each number as key and its index as value.
        Iterate through the array and check if the complement of the current number exists in the map.
        If it does, return the indices of the current number and the complement.
        If it doesn't, add the current number and its index to the map.
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return IntStream.range(0, nums.length).mapToObj(i -> {
            int complement = target - nums[i];
            if (map.containsKey(complement)) return new int[]{i, map.get(complement)};
            map.put(nums[i], i);
            return null;
        }).filter(Objects::nonNull).findFirst().orElse(new int[]{});
    }

    public boolean isAnagramI(String s, String t) {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        Arrays.sort(source);
        Arrays.sort(target);
        for (int i = 0; i < source.length; i++) {
            if (source[i] != target[i]) return false;
        }
        return true;
    }

    public boolean isAnagramII(String s, String t) {
        return Arrays.equals(s.chars().sorted().toArray(), t.chars().sorted().toArray());
    }

    public boolean isAnagramIII(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return mapS.equals(mapT);
    }

    /*
        Approach:
        They should have the same character frequency
    */
    public boolean isAnagramIV(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    /*
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    */
    /*
        Approach:
        Store each word if they're not in the map
        Check if their sorted version is already a key
        If so, add to the current list
        If not, create new list & add
    */
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

    /*
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
    */
    /*
        Approach:
        Use a map to store the frequency of each number
        Sort the map by value in descending order
        Return the first k keys
    */
    public int[] topKFrequentI(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(i -> map.merge(i, 1, Integer::sum));
        return map.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();

    }

    public List<Integer> topKFrequentII(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0 && res.size() < k; i--) {
            if (bucket[i] != null) res.addAll(bucket[i]);
        }
        return res.subList(0, k);
    }

    /*
        Approach:
        Use two arrays to store the prefix and suffix
        The prefix array will store the product of the first i numbers
        The suffix array will store the product of the last i numbers
        The answer array will store the product of the first i numbers and the last i numbers
    */
    public int[] productExceptSelfI(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        int[] prefix = new int[length];
        int[] suffix = new int[length];

        prefix[0] = 1;
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = prefix[i] * suffix[i];
        }
        return answer;
    }

    public int[] productExceptSelfII(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }

    /*    Approach:
        Convert the array nums into a set for O(1) average-time lookups.
        Iterate through each number in the set to find the start of a possible consecutive sequence.
        A number is the start if the number just smaller than it (num - 1) is not in the set.
        For each start number, count consecutive elements by incrementally checking
        if num + 1, num + 2, ... are in the set.
        Track the length of the longest consecutive sequence found.
        Return the maximum length found.
    */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);
        int longest = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }

    /*
    * Approach:
        1. Use two pointers: left -> first, right -> last
        2. Calculate currMax = (right-left+1) X Math.min[heights of them]
            a. left++ -> currMax
            b. right-- -> currMax
            c. Do it together -> currMAx
            d. compare them, update max
        7. Continue until left == right
        8. Return max
        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49
        1-indexed array of integers
    * */
    public int maxArea(int[] height) {
        int left = 0, max = 0, right = height.length - 1;
        while (left < right) {
            int currMax = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, currMax);
            if (height[left] > height[right]) right--;
            else left++;
        }
        return max;
    }

    /*
* Approach:
    1. Use two pointers: left start at 0, right = length - 1
    2. Search for each nums[left] that nums[right] = target - nums[left]
        a. If so, return indices as an array
        b. If not, left++ & right--
    3. Continue until the end
    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    numbers is sorted in non-decreasing order.
    Your solution must use only constant extra space.
    1-indexed array of integers
* */
    public int[] twoSumI(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int complement = target - numbers[left];
            if (numbers[right] == complement) return new int[]{left + 1, right + 1};
            else if (numbers[right] > complement) right--;
            else left++;
        }
        return numbers;
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    /**
     * Approach:
     * 1. Use two pointers: `left` for the last unique element, `right` for scanning.
     * 2. If nums[right] != nums[left], move `left` forward and copy nums[right].
     * 3. Continue until the end; unique elements are shifted to the front.
     * 4. Return count as left + 1.
     */
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public void moveZeroes(int[] nums) {
        int lastNonZero = 0; // index to place the next non-zero element

        // Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZero] = nums[i];
                lastNonZero++;
            }
        }

        // Fill the rest with zeros
        for (int i = lastNonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
