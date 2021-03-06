package leetcode.algorithm.easy.mergetwosortedlists;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 9/10/15 8:30 AM
 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2!=null) return l2;
        if (l1!=null && l2==null) return l1;
        if (l1==null && l2==null) return null;

        ListNode temp = new ListNode(-1);
        ListNode current = temp;
        while (l1!=null && l2!=null){
            if (l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1!=null){
            current.next = l1;
        }
        if (l2!=null){
            current.next = l2;
        }

        return temp.next;
    }

    public static void main(String[] args){
        //1,3,5
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(3);
        ln1.next.next = new ListNode(5);

        //2,4,6
        ListNode ln2 = new ListNode(2);
        ln2.next = new ListNode(4);
        ln2.next.next = new ListNode(6);

        //1,2,3,4,5,6
        ListNode result = mergeTwoLists(ln1, ln2);
        while (result!=null){
            System.out.print(result.val);
            result = result.next;
        }

        //2 null nodes
        ListNode nullNode1 = null;
        ListNode nullNode2 = null;
        result = mergeTwoLists(nullNode1, nullNode2);
        System.out.println("");
        if (result==null){
            System.out.println("return null result as expected");
        }

        //1 null node
        ListNode zeroNode = new ListNode(0);
        result = mergeTwoLists(nullNode1, zeroNode);
        while (result!=null){
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println("");
    }
}
