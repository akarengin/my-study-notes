package leetcode.codingpatterns.linkedlist;

public class Solution {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

      public ListNode(ListNode head) {
          this.val = head.val;
          this.next = head.next;
      }

      public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Create a dummy node to hold the result
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            int carry = 0;

            // Continue until all nodes are processed and no carry remains
            while (l1 != null || l2 != null || carry > 0) {
                int x = (l1 != null) ? l1.val : 0;
                int y = (l2 != null) ? l2.val : 0;

                // Calculate sum and carry
                int sum = x + y + carry;
                int digit = sum % 10;
                carry = sum / 10;

                // Create new node and move current pointer
                current.next = new ListNode(digit);
                current = current.next;

                // Move l1 and l2 to next nodes
                l1 = (l1 != null) ? l1.next : null;
                l2 = (l2 != null) ? l2.next : null;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        // Create test case for addTwoNumbers
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = ListNode.addTwoNumbers(l1, l2);
        System.out.println("addTwoNumbers:");
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public ListNode middleNode1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNode2(ListNode head) {
        if (head.next == null)
            return head;
        ListNode curr = head;
        ListNode middle = head;
        int n = 0;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        for (int i = 0; i <= n / 2; i++) {
            middle = middle.next;
        }
        return middle;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // Compare the first and second halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
