package problems;

import hackerrank.DoublyLinkedListNode;
import hackerrank.SinglyLinkedListNode;
import linkedlist.Node;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}

public class InterviewQuestions {

    public static void main(String[] args) {
        //stringReverse("apple");

        int[] arr = {1, 5, 2, 8, 13};
        //System.out.println(findLargest(arr));

        //System.out.println(checkPrime(2));

        //System.out.println(sieve(3));

        //System.out.println(factorial(5));

        int[] nums = {1, 2, 3, 1, 2, 4, 5};
        //System.out.println(removeDuplicates(nums));

        int[] numbers = {1, 5, 3, 9, 7};
        //System.out.println(secondLargestNumber(numbers));
        //System.out.println(secondLargestNum(numbers));

        String str1 = "silent";
        String str2 = "listen";
        //System.out.println(checkAnagram(str1, str2));

        //System.out.println(anagramCheck(str1, str2));

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        //reverseLinkedList(listNode);

        //System.out.println(nonRepeatingChar("smalltalk"));

        //System.out.println(palindromeCheck("ROTATOR"));

        int[] coins = {3,4};
        int amount = 4;
        coinChange(coins, amount);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        ListNode intersection = findIntersectionNode(headA, headB);
        //System.out.println("Intersection node: " + intersection.val);

        int[] maxSum = {-2, -7, -3, 12, -12, 24, -1, -5, -4};
        int sum = maxSubArraySum(maxSum);
        //System.out.println("Maximum sum subarray: " + sum);

        //fibonacci(4);

        //swap(3, 5);

        System.out.println("sumXor: " + sumXor(4));

    }

    public static void stringReverse(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        //System.out.println(stringBuilder.reverse());
    }

    public static int findLargest(int[] arr) {
        Arrays.stream(arr).sorted();
        return arr[arr.length-1];
    }

    public static boolean checkPrime(int number) {
        for(int i = 2; i <= number/2; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }

    /*
    This method creates a list of primes with the size of q (It's like getPrimes method)
    */
    public static List<Integer> sieve(int q) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int i = 3;
        int count = 1;
        while (count < q) {
            boolean isPrime = true;
            for (Integer p : primes) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
                count++;
            }
            i+=2;
        }
        return primes;
    }

    public static int factorial(int number) {
        int result = number;
        if(number == 0) return 1;
        while (number != 1) {
            number--;
            result *= number;
        }
        return result;
    }

    public static int factorialI(int number) {
        int fact = 1;
        if(number == 0) return 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int fact(int number) {
        if(number == 0) return 1;
        return number * fact(number-1);
    }

    public static String removeDuplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (Integer i : arr) {
            boolean isUnique = set.add(i);
            // if(!isUnique) set.remove(i); it removes repeated numbers completely!
        }
        Integer[] array = set.toArray(new Integer[set.size()]);
        return Arrays.toString(array);
    }

    public static int secondLargestNumber(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-2];
    }

    public static int secondLargestNum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] != max) {
                secondMax = nums[i];
            }
        }
        return secondMax;
    }

    public static boolean checkAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        for (int i= 0; i < str1.length(); i++) {
            if (!str2.contains(str1.subSequence(i,i+1))) {
               return false;
            }
        }
        return true;
    }

    public static boolean anagramCheck(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (Arrays.equals(arr1, arr2)) return true;
        return false;
    }

    //It's case-insensitive (~ for lowercase!)
    public static String nonRepeatingChar(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        for (int j = 0; j < str.length(); j++) {
            if(freq[str.charAt(j)] == 1) return String.valueOf(str.charAt(j));
        }
        return "There are no non-repeating characters in the string.";
    }

    public static boolean palindromeCheck(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
            }
            left++;
            right--;
            return -1;
        }
        return -1;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    void permutation(String str) {
        permutation(str, "");
    }

    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i= 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    /*
     * Given a set of coin denominations and a target amount,
     * find the minimum number of coins needed to make up that amount.
     * If it's not possible to make the amount with the given coins, indicate that.
     *
     * Example:
     * coins = [3,4], amount = 4
     * Output: Minimum coins needed: 1 (using one coin of value 4)
     */
    public static void coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            System.out.println("Not possible to make amount " + amount + " with given coins.");
        } else {
            System.out.println("Minimum coins needed: " + dp[amount]);
        }
    }
    public static int maxSubarraySum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if(currentSum > max) {
                max = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return max;
    }

    public static int maxSubArraySum(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static String caesarCiphers(String s, int k) {
        StringBuilder cipher = new StringBuilder();
        for (Character c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                char baseA = Character.isUpperCase(c) ? 'A' : 'a';
                cipher.append((char) ((c + k - baseA) % 26 + baseA));
            } else {
                cipher.append(c);
            }
        }
        return cipher.toString();
    }

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxSubArr = Integer.MIN_VALUE;
        int maxSubSeq = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            currentSum += num;
            if (currentSum > maxSubArr) {
                maxSubArr = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
            if (num >= 0) maxSubSeq += num;
            if (num > maxSubSeq) maxSubSeq = num;
        }
        return new ArrayList<>(Arrays.asList(maxSubArr, maxSubSeq));
    }

    public static void fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //System.out.println("The " + n + "th Fibonacci number: " + dp[n]);
    }

    public static void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        //System.out.println("Reversed order: " + a + "," + b);
    }

    /*
    * --------------- Nodes & LinkedList -----------------
    */

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        int count = 0;
        postOrder(root.left);
        count++;
        postOrder(root.right);
        count++;
        if (count == 2) System.out.print(root.data + " ");
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        int count = 0;
        inOrder(root.left);
        count++;
        if (count == 1) System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.print(n.data + " ");
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    public static Node insert(Node root,int data) {
        if (root == null) return new Node(data);
        Node curr;
        if (root.data < data) {
            curr = insert(root.right, data);
            root.right = curr;
        } else {
            curr = insert(root.left, data);
            root.left = curr;
        }
        return root;
    }

    public static Node lca(Node root, int v1, int v2) {
        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }
        if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }
        return root;
    }

    public static Node addToEnd(Node head, int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node curr = head;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = n;
            n.left = curr;
        }
        return head;
    }

    public static Node addToStart(Node head, int data) {
        if(head == null) {
            return new Node(data);
        }
        Node n = new Node(data);
        head.left = n;
        n.right = head;
        head = n;
        return head;
    }

    public static Node addToAfter(Node head, int insertAfter, int data) {
        Node curr = head;
        while (curr != null && curr.data != insertAfter) {
            curr = curr.right;
        }
        if(curr == null) {
            return null;
        }
        Node n = new Node(data);
        n.right = curr.right;
        if(curr.right != null) {
            curr.right.left = n;
        }
        curr.right = n;
        n.left = curr;
        return head;
    }

    public static Node deleteLast(Node head) {
        if (head == null || head.right == null) {
            return null;
        }
        Node curr = head;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.left.right = null;
        return head;
    }

    public static Node deleteFirst(Node head) {
        if (head == null) return null;
        return head.right;
    }

    public static Node deleteNodeAfter(Node head, int deleteAfter) {
        Node curr = head;
        while (curr.right != null && curr.data != deleteAfter) {
            curr = curr.right;
        }
        if(curr.right != null) {
            curr.right = null;
        }
        return head;
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        if (llist == null) return null;
        SinglyLinkedListNode curr = llist;
        int idx = 1;
        while (curr.next != null && idx != position) {
            curr = curr.next;
            idx++;
        }
        if (curr == null) return null;
        SinglyLinkedListNode n = new SinglyLinkedListNode(data);
        if(curr.next != null) {
            n.next = curr.next;
        }
        curr.next = n;
        return llist;
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode curr = llist;
        SinglyLinkedListNode prev = null;
        while (curr != null) {
            SinglyLinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // It's easier than below solution!
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        DoublyLinkedListNode curr = llist;
        DoublyLinkedListNode prev = null;
        while (curr != null) {
            DoublyLinkedListNode next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static DoublyLinkedListNode reverses(DoublyLinkedListNode llist) { // newHead = 4 // null <- 4(curr) <-> 3 <-> 2 <-> 1 -> temp(null)             3 <- 2 <-> 3 <-> 4
        DoublyLinkedListNode curr = llist;
        DoublyLinkedListNode newHead =null;
        while (curr != null) {
            DoublyLinkedListNode temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            newHead = curr;
            curr = curr.prev;
        }
        return newHead;
    }

    public static ListNode findIntersectionNode(ListNode node1, ListNode node2) {
        ListNode pointerA = node1;
        ListNode pointerB = node2;
        while (pointerA != pointerB) {
            pointerA = pointerA == null ? node2 : pointerA.next;
            pointerB = pointerB == null ? node1 : pointerB.next;
        }
        return pointerA;
    }

    /*
    * -------------------------------------------------------------------------
    */

    // Write a code which returns the Integer appearing only once in the list
    public static int lonelyIntegers(List<Integer> a) {
        int result = 0;
        for (Integer number : a) {
        /* This line performs a bitwise XOR operation between 'result' and 'number'
           XOR has these properties:
           - When XORing a number with itself, the result is 0
           - When XORing a number with 0, the result is that number
           - XOR is commutative, so order doesn't matter
           Therefore, numbers appearing twice will cancel out (XOR to 0)
           The only remaining value will be the number that appears once */
        result ^= number;
        }
        return result;
    }

    public static long flippingBitss(long n) {
        long mask = (1L << 32) - 1;
        return n ^ mask;
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        int[] charCount = new int[100];
        for(int i = 0; i < arr.size(); i++) {
            charCount[arr.get(i)]++;
        }
        for(int i : charCount) {
            list.add(i);
        }
        return list;
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        boolean b = true;
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i)+B.get(i) < k) b = false;
        }
        return b ? "YES" : "NO";
    }

    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) res += "0";
            else res += "1";
        }
        return res;
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int size = matrix.size();
        int sum = 0;
        for (int i = 0; i < size/2; i++) {
            for (int j = 0; j < size/2; j++) {
                sum += Math.max(matrix.get(i).get(j),
                        Math.max(matrix.get(size - i - 1).get(j),
                                Math.max(matrix.get(i).get(size - j - 1), matrix.get(size - i - 1).get(size - j - 1))));
            }
        }
        return sum;
    }

    public static int maxMin(int k, List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        int abs = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.size()-k; i++) {
            int max = arr.get(i+k-1);
            int min = arr.get(i);
            abs = Math.min(abs, max - min);
        }
        return abs;
    }

    // Convert a number base of 10 to base 2
    public static long flippingBitsWithNegation(int decimal) {
        String binaryString = Integer.toBinaryString(decimal);
        String substring = binaryString.replaceFirst("^0*", "");
        int intRepresentation = Integer.parseUnsignedInt(substring, 2);
        int mask = (1 << substring.length()) - 1 ;
        return intRepresentation ^ mask;
    }

    public static long sumXor(long n) {
        int counter = 0;
        while (n > 0) {
        // This line checks if the least significant bit (rightmost bit) of n is 0
        // Using bitwise AND (&) with 1:
        // - If n ends in 0, then n & 1 = 0
        // - If n ends in 1, then n & 1 = 1
        // We only count bits that are 0 because:
        // For any number x, n|x == n^x is true only when the corresponding bit in n is 0
        // They can match in specific cases, i.e., when no carry bits occur. (means = even number)
        if ((n & 1) == 0) // count only when n|x == n^x
                counter++;
            n = n >> 1; //drop right-most digit
            //(cut the number in half)
        }
        return 1l << counter; //a nice way to rise a number to power of 2
    }

}

