package leetcode.codingpatterns.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = { 1, 1, 4, 2, 1, 3 };
        // System.out.println(solution.heightChecker(arr));
        int[] nums = { 2, 2, 3, 1 };
        // System.out.println("ThirdMax: " + solution.thirdMax4(nums));
        int[] array = { 1, 3, 4, 2, 2 };
        // System.out.println("Duplicate: " + solution.findDuplicate(array));

        int[][] testCases = {
                { 3, 6, 8, 10, 1, 2, 1 },
                { 5, 4, 3, 2, 1 },
                { 1, 2, 3, 4, 5 },
                { 9, -3, 5, 2, 6, 8, -6, 1, 3 },
                {}
        };

        /*
         * System.out.println("Sorted Array: ");
         * for (int[] testCase : testCases) {
         * quickSort(testCase, 0, testCase.length - 1);
         * printArray(testCase);
         * }
         */

        System.out.println("Sorted Array: ");
        int[] arrr = { 3, 2, 1 };
        solution.countingSort(arrr);
        printArray(arrr);

    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public void bubbleSort(int[] nums) {
        // Get the number of elements in the array
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            // Initialize the swapped flag
            boolean swapped = false;
            /*
             * Inner loop traverses up to the unsorted portion of the array
             * as the last i elements are already sorted in their correct
             * position
             */
            for (int j = 0; j < n - i - 1; j++) {
                // Compare the adjacent elements
                if (nums[j] > nums[j + 1]) {
                    // Swap if they are in the wrong order
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true; // Set the swapped flag to True
                }
            }
            // If no elements were swapped, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public void selectionSort(int[] nums) {
        // Get the number of elements in the array
        int n = nums.length;
        // Traverse through all array elements except the last one
        for (int i = 0; i < n - 1; i++) {
            // Assume the current position is the minimum
            int minIndex = i;
            // Find the minimum element in the remaining unsorted portion
            for (int j = i + 1; j < n; j++) {
                // Update minIndex if a smaller element is found
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element of the unsorted portion
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public void insertionSort(int[] nums) {
        int n = nums.length;
        // Traverse from the second element to the last
        for (int i = 1; i < n; i++) {
            // Store the current element
            int key = nums[i];
            int j = i - 1;
            // Shift elements of the sorted portion to the right
            // until the correct position for the key is found
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            // Insert the key at its correct position
            nums[j + 1] = key;
        }
    }

    // Brute Force
    public int firstMissingPositive1(int[] nums) {
        // Start with 1 and increment
        for (int i = 1;; ++i) {
            boolean found = false;
            for (int j = 0; j < nums.length; ++j) {
                // Check if i is in the array
                if (nums[j] == i) {
                    // If found, break to check the next number
                    found = true;
                    break;
                }
            }
            // If i is not found, return it
            if (!found) {
                return i;
            }
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int firstMissingPositive2(int[] nums) {
        // Create a hash set to store the presence of numbers
        HashSet<Integer> numSet = new HashSet<>();
        // Mark the presence of each positive integer in the hash set
        for (int num : nums) {
            if (num > 0) {
                numSet.add(num);
            }
        }
        // Check for the smallest missing positive integer
        for (int i = 1;; ++i) {
            // If i is not found in the hash set
            if (!numSet.contains(i)) {
                // Return the first missing positive integer
                return i;
            }
        }
    }

    // Cyclic Sort
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        // Add 0 to handle 0-based indexing and prevent out-of-bound issues
        nums = Arrays.copyOf(nums, n + 1);
        nums[n] = 0;
        // First pass: Traverse the array and place each number in its correct index
        for (int i = 0; i < n; i++) {
            // While the current number is within the valid range (1 to n) and
            // not already in its correct position, swap it with the number at its correct
            // index.
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]]) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        // Second pass: Traverse again to find the first index i where nums[i] != i
        for (int i = 1; i <= n; i++) {
            if (nums[i] != i)
                // Return the first missing positive
                return i;
        }
        // If all numbers from 1 to n are in their correct places, return n+1
        return n + 1;
    }

    public int heightChecker(int[] heights) {
        int length = heights.length;
        int[] ints = Arrays.copyOf(heights, length);
        boolean swaped = false;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                    swaped = true;
                }
            }
            if (!swaped)
                break;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (heights[i] != ints[i])
                count++;
        }
        return count;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    /*
     * XORs all indices and all values in the array with res.
     * Since XOR-ing a number twice cancels it out,
     * all numbers present in both the index and the array cancel out,
     * leaving only the missing number.
     */
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public int thirdMax1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        int n = arr.length;
        if (n < 3) {
            return arr[n - 1];
        }
        return arr[n - 3];
    }

    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    /*
     * Sort the array in non-increasing order.
     * Traverse the array and count distinct elements.
     * If we have counted 3 numbers, return the current number.
     * If we never counted 3 distinct numbers, return the largest number.
     */
    public int thirdMax2(int[] nums) {
        // Sort the array in non-increasing order.
        Arrays.sort(nums);
        // Reverse array to make it increasing.
        for (int index = 0; index < nums.length / 2; ++index) {
            int temp = nums[index];
            nums[index] = nums[nums.length - 1 - index];
            nums[nums.length - 1 - index] = temp;
        }
        int elemCounted = 1;
        int prevElem = nums[0];
        for (int index = 1; index < nums.length; ++index) {
            // Current element is different from previous.
            if (nums[index] != prevElem) {
                elemCounted += 1;
                prevElem = nums[index];
            }
            // If we have counted 3 numbers then return current number.
            if (elemCounted == 3) {
                return nums[index];
            }
        }
        // We never counted 3 distinct numbers, return largest number.
        return nums[0];
    }

    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public int thirdMax3(int[] nums) {
        // Sorted set to keep elements in sorted order.
        TreeSet<Integer> sortedNums = new TreeSet<Integer>();
        // Iterate on all elements of 'nums' array.
        for (int num : nums) {
            // Do not insert same element again.
            if (sortedNums.contains(num)) {
                continue;
            }
            // If sorted set has 3 elements.
            if (sortedNums.size() == 3) {
                // And the smallest element is smaller than current element.
                if (sortedNums.first() < num) {
                    // Then remove the smallest element and push the current element.
                    sortedNums.pollFirst();
                    sortedNums.add(num);
                }
            }
            // Otherwise push the current element of nums array.
            else {
                sortedNums.add(num);
            }
        }
        // If sorted set has three elements return the smallest among those 3.
        if (sortedNums.size() == 3) {
            return sortedNums.first();
        }
        // Otherwise return the biggest element of nums array.
        return sortedNums.last();
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int thirdMax4(int[] nums) {
        // Three variables to store maximum three numbers till now.
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int num : nums) {
            // This number is already used once, thus we skip it.
            if (firstMax == num || secondMax == num || thirdMax == num) {
                continue;
            }
            // If current number is greater than first maximum,
            // It means that this is the greatest number and first maximum and second max
            // will become the next two greater numbers.
            if (firstMax <= num) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            }
            // When current number is greater than second maximum,
            // it means that this is the second greatest number.
            else if (secondMax <= num) {
                thirdMax = secondMax;
                secondMax = num;
            }
            // It is the third greatest number.
            else if (thirdMax <= num) {
                thirdMax = num;
            }
        }
        // If third max was never updated, it means we don't have 3 distinct numbers.
        if (thirdMax == Long.MIN_VALUE) {
            return (int) firstMax;
        }
        return (int) thirdMax;
    }

    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if ((nums[i] ^ nums[i + 1]) == 0)
                return nums[i];
        }
        return 0;
    }    // Function to merge two sorted subarrays into a single sorted array
    public static void merge(int[] arr, int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        // Copy elements into the left and right temporary arrays
        System.arraycopy(arr, start, left, 0, leftSize);
        //System.arraycopy(arr, mid + 1, right, 0, rightSize);
        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[mid + 1 + i];
        }
        // Merge the left and right subarrays into a single sorted array
        int i = 0, j = 0, k = start;
        // Compare elements from the left and right subarrays and merge them
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        // Copy remaining elements from the left subarray, if any
        while (i < leftSize) {
            arr[k++] = left[i++];
        }
        // Copy remaining elements from the right subarray, if any
        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    // Recursive function to divide the array and sort it
    public static void mergeSort(int[] arr, int start, int end) {
        // Base case: If the array has only one element, it is already sorted
        if (start >= end) {
            return;
        }
        // Find the middle index to divide the array
        int mid = start + (end - start) / 2;
        // Recursively sort the left half
        mergeSort(arr, start, mid);
        // Recursively sort the right half
        mergeSort(arr, mid + 1, end);
        // Merge the two sorted halves
        merge(arr, start, mid, end);
    }



    // Time Complexity: O(m + n)
    // Space Complexity: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            nums1[k--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }

    /**
     * Sorts an array of integers using the QuickSort algorithm.
     * This implementation uses a recursive divide-and-conquer approach.
     *
     * @param arr  The array to be sorted
     * @param low  The starting index of the subarray to be sorted
     * @param high The ending index of the subarray to be sorted
     */
    // Time Complexity: O(n log n)
    // Space Complexity: O(log n)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing last element as pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { // Allow duplicates by using <=
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Time Complexity: O(n + k)
    // Space Complexity: O(k)
    public void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];

        // Step 1: Count occurrences
        for (int num : arr) {
            count[num]++;
        }

        // Step 2: Reconstruct the sorted array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    private void countingSort2(int[] arr) {
        // Create the counting hash map.
        Map<Integer, Integer> counts = new HashMap<>();
        // Find the minimum and maximum values in the array.
        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();

        // Update element's count in the hash map.
        for (int val : arr) {
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }

        int index = 0;
        // Place each element in its correct position in the array.
        for (int val = minVal; val <= maxVal; ++val) {
            // Append all 'val's together if they exist.
            while (counts.getOrDefault(val, 0) > 0) {
                arr[index] = val;
                index += 1;
                counts.put(val, counts.get(val) - 1);
            }
        }
    }

    // Bucket sort function for each place value digit.
    private void bucketSort(int[] arr, int placeValue) {
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        // Store the respective number based on its digit.
        for (int val : arr) {
            int digit = Math.abs(val) / placeValue;
            digit = digit % 10;
            buckets.get(digit).add(val);
        }

        // Overwrite 'arr' in sorted order of current place digits.
        int index = 0;
        for (int digit = 0; digit < 10; ++digit) {
            for (int val : buckets.get(digit)) {
                arr[index] = val;
                index++;
            }
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Bucket sort: index = frequency, value = list of numbers
        // This is an array of List<Integer> objects
        // The syntax List<Integer>[] creates an array where each element can hold a List<Integer>
        // So it's an array of lists, combining both data structures
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // Collect top k from highest frequency buckets
        int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[idx++] = num;
                    if (idx == k) break;
                }
            }
        }
        return result;
    }

    // Radix sort function.
    private void radixSort(int[] arr) {
        
        // Find the absolute maximum element to find max number of digits.
        int maxElement = Arrays.stream(arr).map(Math::abs).max().getAsInt();
        int maxDigits = 0;
        while (maxElement > 0) {
            maxDigits += 1;
            maxElement /= 10;
        }

        // Radix sort, least significant digit place to most significant.
        int placeValue = 1;
        for (int digit = 0; digit < maxDigits; ++digit) {
            bucketSort(arr, placeValue);
            placeValue *= 10;
        }
    }
        

}
