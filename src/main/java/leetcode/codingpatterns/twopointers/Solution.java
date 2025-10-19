package leetcode.codingpatterns.twopointers;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        //solution.reverseString("Reverse string: "+ s);

        //System.out.println("romanToInt: " + solution.romanToInt("III"));

        // Test 3Sum
        int[] nums = {-1,-1,1,2,3,-4};
        List<List<Integer>> result = solution.threeSumII(nums);
        System.out.println("3Sum: " + result);

    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        for (char str : s) System.out.print(str + " ");
    }

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

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int maxAreaI(int[] height) {
        int max = 0;
        int n = height.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int currentMax = (right - left) * Math.min(height[right], height[left]);
            max = Math.max(max, currentMax);
            if (height[right] > height[left]) left++;
            else right--;
        }
        return max;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int[] twoSumI(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int total = numbers[left] + numbers[right];
            if (total == target) return new int[]{left + 1, right + 1};
            else if (total > target) right--;
            else left++;
        }
        return null;
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    public int[] twoSumII(int[] numbers, int target) {
        return IntStream.range(0, numbers.length)
                .mapToObj(i -> {
                    int complement = target - numbers[i];
                    int j = Arrays.binarySearch(numbers, i + 1, numbers.length, complement);
                    if (j >= 0) {
                        return new int[]{i + 1, j + 1};
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        // Pre-allocate space for efficiency
        result.ensureCapacity(s.length() + spaces.length);

        int spaceIndex = 0;
        for (int stringIndex = 0; stringIndex < s.length(); stringIndex++) {
            if (spaceIndex < spaces.length && stringIndex == spaces[spaceIndex]) {
                // Insert space at the correct position
                result.append(' ');
                spaceIndex++;
            }
            // Append the current character
            result.append(s.charAt(stringIndex));
        }

        return result.toString();
    }

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public List<List<Integer>> threeSumI(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else j++;
            }

        }
        return new ArrayList<>(res);
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public List<List<Integer>> threeSumII(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        // Take advantage of the fact that the array is sorted
        // to skip duplicates and reduce the time complexity
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    // If the total is greater than 0, then we need to decrease
                    // the total by moving the right pointer to the left
                    k--;
                } else if (total < 0) {
                    // If the total is less than 0, then we need to increase
                    // the total by moving the left pointer to the right
                    j++;
                } else {
                    // If the total is equal to 0, then we found a valid triplet
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    // Skip duplicates by moving the left pointer to the right
                    // until we find a different number
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }

}
