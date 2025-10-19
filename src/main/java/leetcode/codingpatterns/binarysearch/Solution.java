package leetcode.codingpatterns.binarysearch;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            }
        }
        return right;
    }

    public int searchInRotatedArray(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // Check which half is sorted
            // Adjust pointers based on sorted half and target
            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left half
                } else {
                    left = mid + 1; // Target is in the right half
                }
            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }
        return -1;
    }

    public int minEatingSpeedI(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int left = 1, right = piles[n - 1];
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long hours = 0;
            for (int pile : piles) {
                // ceil(pile / mid) meaning she spends exactly one hour finishing that pile
                // (pile + mid - 1) / mid already covers this rule naturally
                hours += (pile + (long) mid - 1) / mid;
            }
            if (hours > h) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public int minEatingSpeedII(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) hours++;
        }
        return hours <= h;
    }

  /**
   *
   *
   * Input: nums = [4,5,6,7,0,1,2], target = 0
   * Output: 4
   */
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

  public int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[mid + 1]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public int[] searchRange(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        int leftBound = mid;
        int rightBound = mid;
        while (leftBound > 0 && nums[leftBound - 1] == target) {
          leftBound--;
        }
        while (rightBound < nums.length - 1 && nums[rightBound + 1] == target) {
          rightBound++;
        }
        return new int[]{leftBound, rightBound};
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return new int[]{-1, -1};
  }

}
