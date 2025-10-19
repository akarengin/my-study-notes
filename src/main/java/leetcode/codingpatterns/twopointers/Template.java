package leetcode.codingpatterns.twopointers;

import leetcode.codingpatterns.linkedlist.Solution.ListNode;

import java.util.*;

public class Template {

    private boolean CONDITION;

    public static void main(String[] args) {

    }

    // Opposite Ends (e.g., Two Sum in Sorted Array)
    public boolean hasPairSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false;
    }

    // two inputs, exhaust both (different input lengths)
    public int fn(int[] arr1, int[] arr2) {
        int i = 0, j = 0, ans = 0;

        while (i < arr1.length && j < arr2.length) {
            // do some logic here
            if (CONDITION) {
                i++;
            } else {
                j++;
            }
        }

        while (i < arr1.length) {
            // do logic
            i++;
        }

        while (j < arr2.length) {
            // do logic
            j++;
        }

        return ans;
    }

    // Same Direction (Window Expansion)
    public int longestSubstringWithoutRepeat(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left++));
            }
            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Fast and Slow Pointers (Cycle Detection)
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }


}
