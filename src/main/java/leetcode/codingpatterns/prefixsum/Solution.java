package leetcode.codingpatterns.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    class NumArray {

        private int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }

    class NumMatrix {

        private int[][] prefix;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            prefix = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        NumArray numArray = solution.new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
        // System.out.println(numArray.sumRange(0, 2));
        // System.out.println(numArray.sumRange(2, 5));
        // System.out.println(numArray.sumRange(0, 5));

        System.out.println("leftRightDifference: ");
        printArray(solution.leftRightDifference(new int[] { 10, 4, 8, 3 }));
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        // Calculate left sums
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        // Calculate right sums
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        // Calculate absolute differences
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); // Initialize with sum 0 having frequency 1

        for (int num : nums) {
            sum += num;
            // If (sum - k) exists in map, we found a subarray with sum k
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }
            // Update frequency of current sum
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int bestClosingTime(String customers) {
        int[] prefixSum = new int[customers.length() + 1];
        for (int i = 0; i < customers.length(); i++) {
            prefixSum[i + 1] = prefixSum[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            int penalty = (i - prefixSum[i]) + (prefixSum[prefixSum.length - 1] - prefixSum[i]);
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i;
            }
        }
        return bestHour;
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];

        // Build prefix sum matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                // Since prefix is 1-indexed
                answer[i][j] = prefix[r2 + 1][c2 + 1] - prefix[r1][c2 + 1] - prefix[r2 + 1][c1] + prefix[r1][c1];
            }
        }
        return answer;
    }

    class MaxSide {
        int m;
        int n;

        // Time: O(m*n*log(min(m,n)))
        // Space: O(m*n)
        public int maxSideLength(int[][] mat, int threshold) {
            m = mat.length;
            n = mat[0].length;
            int[][] sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
                }
            }

            int lo = 0, hi = Math.min(m, n);

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (isSquareExist(sum, threshold, mid)) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            return hi;
        }

        private boolean isSquareExist(int[][] sum, int threshold, int len) {
            for (int i = len; i <= m; i++) {
                for (int j = len; j <= n; j++) {
                    if (sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len] <= threshold)
                        return true;
                }
            }
            return false;
        }
    }

    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    public int maxSideLength2(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];

        int res = 0;
        int len = 1; // square side length

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];

                if (i >= len && j >= len
                        && sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len] <= threshold)
                    res = len++;
            }
        }

        return res;
    }

    // Time Complexity: O(n + q)
    // Space Complexity: O(n)
    public int[] vowelStrings(String[] words, int[][] queries) {
        List<Character> asList = Arrays.asList('a', 'e', 'i', 'o', 'u');
        Set<Character> vowels = new HashSet<>(asList);
        int[] prefix = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);
            if (vowels.contains(first) && vowels.contains(last)) {
                prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prefix[right + 1] - prefix[left];
        }
        return result;
    }
}
