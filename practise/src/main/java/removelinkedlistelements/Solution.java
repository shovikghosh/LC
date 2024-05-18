package removelinkedlistelements;

import utilclasses.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        else if (head.val == val)
            return removeElements(head.next, val);
        else
            return removeElements(head, head, val);
    }

    public ListNode removeElements(ListNode head, ListNode cur, int val) {
        if (cur == null || cur.next == null)
            return head;
        ListNode next = cur.next;
        while (cur.next!= null && cur.next.val == val) {
            next = cur.next;
            cur.next = cur.next.next;
        }
        return removeElements(head, next, val);
    }
}
