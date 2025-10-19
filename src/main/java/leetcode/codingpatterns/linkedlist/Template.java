package leetcode.codingpatterns.linkedlist;

import leetcode.codingpatterns.linkedlist.Solution.ListNode;

public class Template {

    // Linked list: fast and slow pointer
    public int fn(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int ans = 0;

        while (fast != null && fast.next != null) {
            // do logic
            slow = slow.next;
            fast = fast.next.next;
        }

        return ans;
    }

    // Reversing a linked list
    public ListNode fn1(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
    
        return prev;
    }

  // Merge Two Sorted LinkedLists
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);  // placeholder node
    ListNode tail = dummy;             // pointer to build the merged list

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {         // pick smaller node
        tail.next = l1;
        l1 = l1.next;
      } else {
        tail.next = l2;
        l2 = l2.next;
      }
      tail = tail.next;              // move tail forward
    }

    // Attach remaining nodes (only one list can be non-empty now)
    tail.next = (l1 != null) ? l1 : l2;

    return dummy.next;                 // skip dummy, return real head
  }


  // Detect Cycle in LinkedList
  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }
    return false;
  }

  // Remove N-th Node from End
  /* Key Insight
  *
  * By maintaining a gap of `n` between `first` and `second`, when `first` reaches
  * the end, second` is positioned right before the node to delete.
  *
  * */
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
