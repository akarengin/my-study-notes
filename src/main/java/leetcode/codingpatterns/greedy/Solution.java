package leetcode.codingpatterns.greedy;

import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int result = solution.minimumMergeCost(nums);
        System.out.println("Minimum total cost: " + result); // Output: 9
    }

    public int minimumMergeCost(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all elements to the heap
        for (int num : nums) {
            minHeap.offer(num);
        }

        int totalCost = 0;

        // Continue until one element is left
        while (minHeap.size() > 1) {
            int first = minHeap.poll();   // smallest
            int second = minHeap.poll();  // second smallest

            int sum = first + second;
            totalCost += sum;

            // Put the sum back into the heap
            minHeap.offer(sum);
        }

        return totalCost;
    }

}
