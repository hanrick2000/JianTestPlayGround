package ninechapter_algorithm.chapter6_linkedlist.optional.rotatelist.third;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/25/16 16:12
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || k == 0) {
            return head;
        }

        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        int num = k % len;
        if (num == 0) {
            return head;
        }
        ListNode fast = head;
        for (int i = 1; i <= num; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
