package leetcode.codingpatterns.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Template {

    private boolean CONDITION;

    // For problems where the window size is know
    public int maxSumSubarray(int[] nums, int k) {
        int windowSum = 0, maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i >= k) windowSum -= nums[i - k];  // Slide the window
            if (i >= k - 1) maxSum = Math.max(maxSum, windowSum); // Check the max for that window
        }
        return maxSum;
    }

    // For problems where you expand or shrink based on a condition.
    public int longestSubstringWithoutRepeat(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // For problems like subarray count or product constraints.
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int product = 1, count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) product /= nums[left++];
            count += right - left + 1;
        }
        return count;
    }

    //Two pointers: one input, opposite ends
    public int fn(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;
    
        while (left < right) {
            // do some logic here with left and right
            if (CONDITION) {
                left++;
            } else {
                right--;
            }
        }
    
        return ans;
    }
    
}
