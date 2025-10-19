package leetcode.codingpatterns.slidingwindow;


import java.util.*;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[]{8, 2, 4, 7};
    System.out.println("Longest subarray is: " + solution.longestSubarray2(nums, 4));

    int[] arr = {4, 2, 1, 3, 3};
    //System.out.println("Max average is: " + solution.findMaxAverage2(arr, 2));

    int[] array = {1, 3, 2, 2, 5, 2, 3, 7};
    //System.out.println("Longest Harmonious Subsequence: " + solution.findLHS(array));
  }

  public int maxProfit(int[] prices) {
    int l = 0, r = 1;
    int maxP = 0;

    while (r < prices.length) {
      if (prices[l] < prices[r]) {
        int profit = prices[r] - prices[l];
        maxP = Math.max(maxP, profit);
      } else {
        l = r;
      }
      r++;
    }
    return maxP;
  }

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s == null || p == null || s.length() < p.length()) {
      return result;
    }

    int[] charCount = new int[26];
    // Initialize the frequency map for p
    for (char c : p.toCharArray()) {
      charCount[c - 'a']++;
    }

    int left = 0;
    int right = 0;
    int count = p.length();

    while (right < s.length()) {
      // If current character exists in p, decrement count
      if (charCount[s.charAt(right++) - 'a']-- >= 1) {
        count--;
      }

      // If count is 0, we found an anagram
      if (count == 0) {
        result.add(left);
      }

      // If the window size equals p's length, move left pointer
      if (right - left == p.length()) {
        // If the character at left was in p, increment count
        if (charCount[s.charAt(left++) - 'a']++ >= 0) {
          count++;
        }
      }
    }

    return result;
  }

  public int longestSubarray1(int[] nums, int limit) {
    // TreeMap to maintain the elements within the current window
    TreeMap<Integer, Integer> window = new TreeMap<>();
    int left = 0, maxLength = 0;

    for (int right = 0; right < nums.length; ++right) {
      window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

      // Check if the absolute difference between the maximum and minimum values in the current window exceeds the limit
      while (window.lastKey() - window.firstKey() > limit) {
        // Remove the element at the left pointer from the TreeMap
        window.put(nums[left], window.get(nums[left]) - 1);
        if (window.get(nums[left]) == 0) {
          window.remove(nums[left]);
        }
        // Move the left pointer to the right to exclude the element causing the violation
        ++left;
      }

      // Update maxLength with the length of the current valid window
      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }

  // FP way #1 --- Using TreeMap
  // Time Complexity: O(n * log n)
  // - TreeMap operations (get/put/remove) take O(log n)
  // - We process each element once, and for each element we may perform multiple TreeMap operations
  // - In worst case, we might need to remove all elements from window for each new element
  // Space Complexity: O(n) for the TreeMap storing window elements
  public int longestSubarray2(int[] nums, int limit) {
    final TreeMap<Integer, Integer> window = new TreeMap<>();
    // Array used to track left boundary of sliding window
        /*It's equivalent to new int[]{0, 1} - just a shorter syntax
         This array initialization syntax was introduced in Java 10 with the 'var' feature*/
    final int[] left = {0};
    return IntStream.range(0, nums.length)
        // Process each index as right boundary of window
        .map(right -> {
          // Add current element to window frequency map
          window.merge(nums[right], 1, Integer::sum);

          // Shrink window from left while max-min difference exceeds limit
          while (window.lastKey() - window.firstKey() > limit) {
            // Decrease frequency of leftmost element
            window.merge(nums[left[0]], -1, Integer::sum);
            // Remove element if frequency becomes 0
            if (window.get(nums[left[0]]) == 0) {
              window.remove(nums[left[0]]);
            }
            // Move left boundary right
            left[0]++;
          }

          // Return current window size
          return right - left[0] + 1;
        })
        // Find maximum window size across all positions
        .max().orElse(0);
  }

  // OC way #1 --- Using Deque
  // Time Complexity: O(n), where n is the length of the input array
  // - Each element is pushed and popped at most once from each deque
  // - The outer loop runs n times
  // - The inner while loops combined process each element at most once
  // Space Complexity: O(n) for storing elements in the deques
  public int longestSubarray3(int[] nums, int limit) {
    // Declare deques to track the max and min values within the current window
    Deque<Integer> maxDeque = new LinkedList<>();
    Deque<Integer> minDeque = new LinkedList<>();

    // Initialize left pointer for the sliding window
    int left = 0;
    int maxLength = 0; // Variable to store the maximum length of the valid subarray

    // Iterate through the array with right pointer
    for (int right = 0; right < nums.length; right++) {

      // Maintain the max deque: remove all elements smaller than the current element
      while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
        maxDeque.pollLast();
      }
      maxDeque.offerLast(right);

      // Maintain the min deque: remove all elements larger than the current element
      while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
        minDeque.pollLast();
      }
      minDeque.offerLast(right); // Add current element index to the min deque

      // Shrink the window from the left if the absolute difference condition is violated
      while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
        // If the leftmost index of max deque is out of the window, poll it
        if (maxDeque.peekFirst() == left) {
          maxDeque.pollFirst();
        }
        // If the leftmost index of min deque is out of the window, poll it
        if (minDeque.peekFirst() == left) {
          minDeque.pollFirst();
        }
        left++; // Move left pointer to shrink the window
      }

      // Calculate the maximum length of the subarray
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength; // Return the result
  }

  // FP way #1
  // Time Complexity: O(n*k)
  // Space Complexity: O(1)
  // - The IntStream and Arrays.stream operations process elements one at a time without storing them
  // - Only a constant amount of memory is used for intermediate calculations
  public double findMaxAverage1(int[] nums, int k) {
    return IntStream.range(0, nums.length - k + 1)
        .mapToDouble(i -> Arrays.stream(nums).skip(i).limit(k).average().orElse(0.0)).max()
        .orElse(0.0);
  }

  // OC way #1
  // Time Complexity: O(n) - we iterate through the array once
  // Space Complexity: O(1) - we only use a constant amount of extra space
  public double findMaxAverage2(int[] nums, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    int maxSum = sum;
    for (int i = k; i < nums.length; i++) {
      sum = sum + nums[i] - nums[i - k];
      maxSum = Math.max(maxSum, sum);
    }
    return (double) maxSum / k;
  }

  // Hybrid way #1
  // Time complexity: O(n)
  // Space Complexity: O(n) - we store an array of prefix sums of size n+1
  public double findMaxAverage3(int[] nums, int k) {
    int n = nums.length;
    int[] prefixSums = new int[n + 1]; // All elements are zero
    for (int i = 0; i < n; i++) {
      prefixSums[i + 1] = prefixSums[i] + nums[i];
      // prefixSums[1] = prefixSums[0] + nums[0]
      // prefixSums[2] = prefixSums[1] + nums[1]
      // prefixSums[3] = prefixSums[2] + nums[2]
    }
    return IntStream.range(0, n - k)
        .mapToDouble(i -> (prefixSums[i + k] - prefixSums[i]) / (double) k).max().orElse(0.0);
  }

  // Old-school (OC) way #1
  // Time Complexity: O(n) where n is the length of the input array
  // Space Complexity: O(k) where k is the number of unique elements in the array
  public int findLHS(int[] nums) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }
    int maxLength = 0;
    for (int num : frequencyMap.keySet()) {
      // If num+1 exists in map, we have a harmonious subsequence
      if (frequencyMap.containsKey(num + 1)) {
        int currentLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
        maxLength = Math.max(maxLength, currentLength);
      }
    }
    return maxLength;
  }

  // OC way #1
  // Time complexity: O(n)
  // Space complexity is O(min(n,k)) as we only store k elements at most

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> window = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      // If window size exceeds k, remove the leftmost element
      if (i > k) {
        window.remove(nums[i - k - 1]);
      }

      // If current number is already in the window, we found a duplicate
      if (!window.add(nums[i])) {
        return true;
      }
    }

    return false;
  }

  /*
        Intuition:

        Iterate through the array and keep track of characters we've seen with a set.
        If we see a character that is already in the set, we've found a duplicate.
        Calculate the length of the substring and update the max if necessary.
        Shift the left pointer to the right and remove the character at the left pointer from the set.
        Return the max length.
  */
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0, max = 0;
    for (int right = 0; right < s.length(); right++) {
      while (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
      }
      set.add(s.charAt(right));
      max = Math.max(max, right - left + 1);
    }
    return max;
  }

    /*
            Intuition:

            Iterate through the string and keep track of the last seen position of each character.
            If we see a character that we've seen before, calculate the length of the substring
            and update the max if necessary.
            We only need to keep track of the last seen position of the characters in the current
            substring, so we can use a Map of size 26.
            If the character is not in the map, add it with its current position.
            If the character is in the map, calculate the length of the substring and update the max if necessary.
            Shift the left pointer to the right and remove the character at the left pointer from the map.
            Return the max length.
    */

  /**
   * Time Complexity: O(n²) - In the worst case where all characters are the same, the nested loops
   * result in quadratic time complexity. Space Complexity: O(n²) - The counts map can store up to
   * n² entries in the worst case, as each character can have up to n different lengths.
   */
  public int maximumLengthI(String s) {
    Map<Pair<Character, Integer>, Integer> counts = new HashMap<>();
    int i = 0;
    int n = s.length();

    while (i < n) {
      char ch = s.charAt(i);
      int start = i;

      while (i < n && s.charAt(i) == ch) {
        i++;
      }

      int runLength = i - start;

      // Count all substring lengths within the run
      for (int len = 1; len <= runLength; len++) {
        int freq = runLength - len + 1;
        Pair<Character, Integer> key = new Pair<>(ch, len);
        counts.put(key, counts.getOrDefault(key, 0) + freq);
      }
    }

    int result = -1;
    for (Map.Entry<Pair<Character, Integer>, Integer> entry : counts.entrySet()) {
      int len = entry.getKey().second;
      int freq = entry.getValue();
      if (freq >= 3) {
        result = Math.max(result, len);
      }
    }

    return result;
  }

  static class Pair<A, B> {

    public final A first;
    public final B second;

    public Pair(A first, B second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Pair<?, ?> pair = (Pair<?, ?>) o;
      return java.util.Objects.equals(first, pair.first) && java.util.Objects.equals(second,
          pair.second);
    }

    @Override
    public int hashCode() {
      return java.util.Objects.hash(first, second);
    }
  }

  /*   ---------- OR -------------- */

    /*
    record Pair<A, B>(A first, B second) {

    }
    */

  // Time complexity: O(n)
  // Space complexity: O(n)
  public int maximumLengthII(String s) {
    int n = s.length();
    // Map each character to an array of counts per substring length
    Map<Character, int[]> freq = new HashMap<>();
    int i = 0;

    while (i < n) {
      char c = s.charAt(i);
      int j = i;

      // Find length of this run
      while (j < n && s.charAt(j) == c) {
        j++;
      }
      int len = j - i;

      // Fill/update frequency array for this character
      int[] arr = freq.computeIfAbsent(c, k -> new int[n + 1]);
      for (int L = 1; L <= len; L++) {
        arr[L] += (len - L + 1);
      }

      i = j; // move to next run
    }

    // Find max substring length with frequency >= 3
    int ans = -1;
    for (int[] arr : freq.values()) {
      for (int L = arr.length - 1; L >= 1; L--) {
        if (arr[L] >= 3) {
          ans = Math.max(ans, L);
          break; // no need to check smaller L for this char
        }
      }
    }

    return ans;
  }

  public int maximumLengthIII(String s) {
    int low = 1, high = s.length();

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (ableToFindString(s, mid)) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return (high == 0) ? -1 : high;
  }

  private boolean ableToFindString(String s, int windowSize) {
    HashMap<String, Integer> map = new HashMap<>();
    int j = 0;
    StringBuilder sb = new StringBuilder();

    while (j < s.length()) {
      if (j == 0 || (!sb.isEmpty() && sb.charAt(sb.length() - 1) == s.charAt(j))) {
        sb.append(s.charAt(j));
      } else {
        sb = new StringBuilder();
        sb.append(s.charAt(j));
      }

      if (sb.length() > windowSize) {
        sb.deleteCharAt(0);
      }

      if (sb.length() == windowSize) {
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

        if (map.get(sb.toString()) >= 3) {
          return true;
        }
      }

      j++;
    }

    return false;
  }

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] s1arr = new int[26];
    int[] s2arr = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      s1arr[s1.charAt(i) - 'a']++;
      s2arr[s2.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s2.length() - s1.length(); i++) {
      if (matches(s1arr, s2arr)) {
        return true;
      }
      s2arr[s2.charAt(i + s1.length()) - 'a']++;
      s2arr[s2.charAt(i) - 'a']--;
    }
    return matches(s1arr, s2arr);
  }

  public boolean matches(int[] s1arr, int[] s2arr) {
    for (int i = 0; i < 26; i++) {
      if (s1arr[i] != s2arr[i]) {
        return false;
      }
    }
    return true;
  }

  // Input: s = "ABAB", k = 2
  // Input: s = "AABABBA", k = 1
    /*
        Approach:
        Iterate through string until reaching k
        Then remove left from the window, shift left to the right
         Compare maximums windows
    */
  public int characterReplacement(String s, int k) {
    int[] freq = new int[26]; // frequency of each character
    int left = 0, maxCount = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      freq[c - 'A']++;
      maxCount = Math.max(maxCount, freq[c - 'A']);

      // If more than k replacements are needed, shrink the window
      while ((right - left + 1) - maxCount > k) {
        freq[s.charAt(left) - 'A']--;
        left++;
      }

      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
  }

  public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int totalSum = 0;
    for (int point : cardPoints) {
      totalSum += point;
    }

    // Size of the window to drop
    int windowSize = n - k;

    // Edge case: if we take all cards
    if (windowSize == 0)
      return totalSum;

    // Initial window sum (first n-k elements)
    int windowSum = 0;
    for (int i = 0; i < windowSize; i++) {
      windowSum += cardPoints[i];
    }

    int minWindowSum = windowSum;

    // Slide the window across the array
    for (int i = windowSize; i < n; i++) {
      windowSum += cardPoints[i] - cardPoints[i - windowSize];
      minWindowSum = Math.min(minWindowSum, windowSum);
    }

    // Max score = total - smallest dropped window
    return totalSum - minWindowSum;
  }


}
