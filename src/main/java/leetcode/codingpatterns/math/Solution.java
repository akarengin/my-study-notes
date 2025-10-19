package leetcode.codingpatterns.math;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Palindrome: " + solution.isPalindrome(234));
    }

    public boolean isPalindrome(int x) { // 123 -> 3
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        int originalNumber = x;

        while (x > 0) {
            int digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }

        return originalNumber == reversedNumber;
    }
}
