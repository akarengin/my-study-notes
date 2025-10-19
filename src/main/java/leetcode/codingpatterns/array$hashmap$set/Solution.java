package leetcode.codingpatterns.array$hashmap$set;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Use a static map to avoid recreating it for each method call
    static final Map<Character, Integer> ROMAN_VALUES = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = solution.groupAnagram(input);
        //System.out.println("Group Anagrams: " + resultList);

        //System.out.println("Isomorphic: " + solution.isIsomorphicFunctional("egg", "add"));

        String s = "aacc";
        String t = "ccac";
        //System.out.println("Is Anagram: " + solution.isAnagram2(s, t));

        // Test encode and decode
        List<String> testList = Arrays.asList("apple", "banana", "kiwi");
        String encoded = solution.encode1(testList);
        //System.out.println("Encoded: " + encoded);
        List<String> decoded = solution.decode2(encoded);
        //System.out.println("Decoded: " + decoded);

        // Test productExceptSelf
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelfI(nums);
        //System.out.println("\nTesting productExceptSelf:");
        //System.out.println("Input array: " + Arrays.toString(nums));
        //System.out.println("Result: " + Arrays.toString(result) + " (Expected: [24, 12, 8, 6])");

        // Test maxProduct
        //System.out.println("\nTesting maxProduct:");
        int[] test = {2, 3, -2, 4};
        //System.out.println("Max Product: " + solution.maxProduct1(test));

        // Test rob
        int[] nums1 = {1, 2, 1, 1};
        //System.out.println("\nTesting rob:");
        //System.out.println("Input array: " + Arrays.toString(nums1));
        //System.out.println("Max Rob: " + solution.robII(nums1));

        // Test highestRatedProduct
        int[][] nums2 = {{123, 2}, {512, 3}, {897, 4}, {123, 6}};
        System.out.println("\nTesting highestRatedProduct:");
        System.out.println("Input array: " + Arrays.toString(nums2));
        System.out.println("Highest Rated Product: " + solution.highestRatedProduct(nums2));

    }

    // Using StringBuilder is more efficient than creating new String objects in a loop
    // StringBuilder allows in-place modification of the character sequence
    // While new String() would create a new object on each iteration
    // This implementation reuses the same StringBuilder object across iterations
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            sb.setLength(0);
            sb.append(chars);
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int majorityElement1(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2)
                return key;
        }
        return 0;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    // Boyer-Moore Voting Algorithm
    public int majorityElement2(int[] nums) { // nums = [2,2,1,1,1,2,2]
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
            System.out.print(count + " ");
        }
        return candidate;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        return resultSet.stream().mapToInt(Integer::intValue).toArray();
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean hasDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : nums) {
            if (!set.add(number))
                return true;
        }
        return false;
    }

    // Functional way
    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean hasDuplicate11(int[] nums) {
        return nums.length != Arrays.stream(nums).distinct().count();
    }

    public boolean hasDuplicate2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.putIfAbsent(num, num) != null)
                return true;
        }
        return false;
    }

    public boolean hasDuplicate3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) != 1)
                return true;
        }
        return false;
    }

    public boolean hasDuplicate4(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;
        return Arrays.equals(
                s.chars().sorted().toArray(),
                t.chars().sorted().toArray());
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return mapS.equals(mapT);
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] twoSumI(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    // Functional way
    public int[] twoSumII(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return IntStream.range(0, nums.length)
                .mapToObj(i -> {
                    int complement = target - nums[i];
                    if (map.containsKey(complement)) {
                        return new int[]{i, map.get(complement)};
                    }
                    map.put(nums[i], i);
                    return null;
                }).filter(Objects::nonNull).findFirst().orElse(new int[]{});
    }

    public int romanToInt(String s) {

        int sum = 0;
        int prevValue = 0;

        // Iterate from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = ROMAN_VALUES.get(s.charAt(i));

            // If current value is less than previous value, subtract it
            // Otherwise add it
            if (currentValue < prevValue) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }

            prevValue = currentValue;
        }

        return sum;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean findTarget(TreeNode root, int k) {
        // Collect all node values into a set using a functional approach
        Set<Integer> values = collectValues(root);

        // Use streams to check if there exists two distinct values that sum to k
        return values.stream()
                .anyMatch(val -> (k - val != val) && values.contains(k - val));
    }

    private Set<Integer> collectValues(TreeNode root) {
        if (root == null)
            return new HashSet<>();
        Set<Integer> result = new HashSet<>();
        // Add current node value
        result.add(root.val);
        // Merge with left subtree values
        result.addAll(collectValues(root.left));
        // Merge with right subtree values
        result.addAll(collectValues(root.right));
        return result;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean findTarget1(TreeNode root, int k) {
        // HashSet to store values we've seen so far
        HashSet<Integer> table = new HashSet<>();

        // Queue for BFS traversal
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            // Remove the node from the front of the queue
            root = list.pollFirst();

            // Check if the complement (k - root.val) exists in the set
            if (table.contains(k - root.val))
                return true;

            // Add the current value to the set
            table.add(root.val);

            // Add left and right children to the queue if they exist
            if (root.left != null)
                list.addLast(root.left);
            if (root.right != null)
                list.addLast(root.right);
        }

        // If no such pair is found, return false
        return false;
    }

    public boolean findTargetII(TreeNode root, int k) {
        return findTargetHelper(root, k, new HashSet<>());
    }

    private boolean findTargetHelper(TreeNode node, int k, Set<Integer> seen) {
        if (node == null) return false;

        int complement = k - node.val;
        if (seen.contains(complement)) {
            return true;
        }

        seen.add(node.val);

        return findTargetHelper(node.left, k, seen) ||
                findTargetHelper(node.right, k, seen);
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if (mapST.containsKey(cS) && mapST.get(cS) != cT) {
                return false;
            }
            if (mapTS.containsKey(cT) && mapTS.get(cT) != cS) {
                return false;
            }
            mapST.put(cS, cT);
            mapTS.put(cT, cS);
        }
        return true;
    }

    // Functional programming style
    public boolean isIsomorphicFunctional(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        return IntStream.range(0, s.length())
                .allMatch(i -> {
                    char cS = s.charAt(i);
                    char cT = t.charAt(i);
                    boolean validST = !mapST.containsKey(cS) || mapST.get(cS) == cT;
                    boolean validTS = !mapTS.containsKey(cT) || mapTS.get(cT) == cS;
                    if (validST && validTS) {
                        mapST.put(cS, cT);
                        mapTS.put(cT, cS);
                        return true;
                    }
                    return false;
                });
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len / 2];
    }

    // Functional programming style
    public int majorityElement4(int[] nums) {
        return Arrays.stream(nums).sorted().toArray()[nums.length / 2];
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public List<String> removeAnagrams1(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!sorted.equals(prev)) {
                result.add(word);
                prev = sorted;
            }
        }
        return result;
    }

    // Functional programming style
    public List<String> removeAnagrams2(String[] words) {
        return IntStream.range(0, words.length)
                .filter(i -> {
                    if (i == 0)
                        return true;
                    char[] prevChars = words[i - 1].toCharArray();
                    char[] currChars = words[i].toCharArray();
                    Arrays.sort(prevChars);
                    Arrays.sort(currChars);
                    return !Arrays.equals(prevChars, currChars);
                })
                .mapToObj(i -> words[i])
                .collect(Collectors.toList());
    }

    public List<String> removeAnagrams3(String[] words) {
        List<String> resultList = new ArrayList<>();
        resultList.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!areAnagrams(words[i], resultList.get(resultList.size() - 1))) {
                resultList.add(words[i]);
            }
        }
        return resultList;
    }

    private boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int scoreOfString1(String s) {
        int asciiAbsolute = 0;
        for (int j = 0; j < s.length() - 1; j++) {
            asciiAbsolute += Math.abs(s.charAt(j + 1) - s.charAt(j));
        }
        return asciiAbsolute;
    }

    // Functional programming style
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int scoreOfString2(String s) {
        return IntStream.range(0, s.length() - 1)
                .map(i -> Math.abs(s.charAt(i) - s.charAt(i + 1)))
                .sum();
    }

    public List<List<String>> groupAnagram(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> {
                    char[] c = s.toCharArray();
                    Arrays.sort(c);
                    return new String(c);
                }))
                .values());
    }

    // Time complexity: O(n + log n)
    // Space complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public String encode(List<String> strs) {
        return strs.stream()
                .collect(Collectors.joining("/"));
    }

    public List<String> decode(String str) {
        return Arrays.stream(str.split("/"))
                .collect(Collectors.toList());
    }

    public String encode1(List<String> strs) {
        if (strs.isEmpty())
            return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs) {
            sizes.add(str.length());
        }
        for (int size : sizes) {
            res.append(size).append(',');
        }
        res.append('#');
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }


    public List<String> decode2(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for (int sz : sizes) {
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
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

    // Time complexity: O(n)
    // Space complexity: O(n)
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

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int maxProduct1(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int prefix = 0, suffix = 0;

        for (int i = 0; i < n; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[n - 1 - i] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int maxSubArrayI(int[] nums) {
        int res = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], nums[i] + max);
            res = Math.max(res, max);
        }
        return res;
    }

    // Functional way
    public int maxSubArrayII(int[] nums) {
        return Arrays.stream(nums)
                .skip(1)
                .boxed()
                .reduce(new int[]{nums[0], nums[0]}, (acc, i) -> {
                    int currentMax = Math.max(i, i + acc[1]);
                    int globalMax = Math.max(acc[0], currentMax);
                    return new int[]{globalMax, currentMax};
                }, (a, b) -> a)[0];
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int totalCount = 0;
        int product = 1;
        for (int left = 0, right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            totalCount += right - left + 1;
        }

        return totalCount;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public long getDescentPeriods1(int[] prices) {
        int i = 0;
        int count = 1;
        while (i < prices.length - 1) {
            if (prices[i] - prices[i + 1] == 1) {
                count++;
            } else {
                count = 1;
            }
            i++;
        }
        return count;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public long getDescentPeriods2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        long count = 1; // The first element is always a period of length 1
        int currentStreak = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }
            count += currentStreak;
        }
        return count;
    }

    private int[] memo;

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int robI(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(dfs(nums, i + 1),
                nums[i] + dfs(nums, i + 2));
        return memo[i];
    }

    private int[] robbed;

    public int robII(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // Case 1: Rob houses from 0 to n-2 (exclude the last house)
        int max1 = robHelper(nums, 0, nums.length - 2);

        // Case 2: Rob houses from 1 to n-1 (exclude the first house)
        int max2 = robHelper(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    private int robHelper(int[] nums, int start, int end) {
        memo = new int[nums.length];
        Arrays.fill(robbed, -1);
        return robRecursive(nums, start, end);
    }

    private int robRecursive(int[] nums, int i, int end) {
        if (i > end) {
            return 0;
        }

        if (robbed[i] != -1) {
            return robbed[i];
        }

        // Option 1: Rob current house and skip the next one
        int robCurrent = nums[i] + robRecursive(nums, i + 2, end);
        // Option 2: Skip current house and move to the next one
        int skipCurrent = robRecursive(nums, i + 1, end);

        robbed[i] = Math.max(robCurrent, skipCurrent);
        return robbed[i];
    }

    // Approach: Binary Tree + Dynamic Programming
    public int robIII(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * Returns an array of two integers:
     * result[0] is the max money if we rob the current node.
     * result[1] is the max money if we skip the current node.
     */
    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[2]; // [rob, skip]
        }

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        // If we rob the current node, we cannot rob its children.
        // So we take the 'skip' values from the children.
        int robCurrent = root.val + left[1] + right[1];

        // If we skip the current node, we are free to either rob or skip its children.
        // We take the max value from the left and right subtrees.
        int skipCurrent = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robCurrent, skipCurrent};
    }

    // int[][] rating = {{123, 2}, {512, 3}, {897, 4}, {123, 6}}
    public int highestRatedProduct(int[][] rating) {
        if (rating == null || rating.length == 0) return -1;

        // Reshape: group by productId -> [sumOfRatings, count]
        Map<Integer, long[]> agg = new HashMap<>();
        for (int[] r : rating) {
            if (r == null || r.length < 2) continue;
            long[] a = agg.computeIfAbsent(r[0], k -> new long[2]);
            a[0] += r[1]; // sum
            a[1] += 1;    // count
        }

        // Find product with highest average; tie-breaker: smaller productId wins
        int bestProduct = -1;
        double bestAvg = Double.NEGATIVE_INFINITY;
        for (Map.Entry<Integer, long[]> e : agg.entrySet()) {
            long sum = e.getValue()[0];
            long count = e.getValue()[1];
            double avg = count == 0 ? 0.0 : (double) sum / count;
            if (avg > bestAvg || (avg == bestAvg && (bestProduct == -1 || e.getKey() < bestProduct))) {
                bestAvg = avg;
                bestProduct = e.getKey();
            }
        }
        return bestProduct;
    }
}