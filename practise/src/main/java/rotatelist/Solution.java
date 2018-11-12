package rotatelist;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        s.print(l1);

        ListNode t = s.rotateRight(l1, 10);
        System.out.println("====");
        s.print(t);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        ListNode cur = head;
        int c = 0;
        while (cur != null && ++c < k) {
            cur = cur.next;
        }
        head = reverse(head, Integer.MAX_VALUE);
        // System.out.println("xxxxx");
        print(head);
        // System.out.println("CUR1:" + c);
        if (cur == null) {
            k = k % c;
            cur = head;
            c = k;
            while (--c >= 0) {
                cur = cur.next;
            }
        }
        if (k == 0) {
            return reverse(head, Integer.MAX_VALUE);
        }
        head = reverse(head, k);
        c = 0;
        cur = head;
        // System.out.println("HWAD: " + head.val);
        while (cur != null && ++c < k) {
            cur = cur.next;
        }
        cur.next = reverse(cur.next, Integer.MAX_VALUE);
        return head;
    }

    void print(ListNode head) {
        if (head != null) {
            System.out.println(head.val);
            print(head.next);
        }
    }

    ListNode reverse(ListNode head, int k) {
        if (k == 0 || k == 1) {
            return head;
        }
        // System.out.println("Called:" + k);
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (--k > 0 && cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        if (cur != null) {
            head.next = cur.next;
            cur.next = prev;
        } else {
            head.next = null;
        }
        return cur != null ? cur : prev;
    }
}

