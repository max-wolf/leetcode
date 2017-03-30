class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode ltmp = head;
        ListNode l1tmp = l1;
        ListNode l2tmp = l2;
        int carry = 0;
        while (l1tmp != null && l2tmp != null) {
            int tmp = l1tmp.val + l2tmp.val + carry;
            if(tmp > 9) {
                int v = tmp % 10;
                carry = 1;
                ltmp.next = new ListNode(v);
            } else {
                carry = 0;
                ltmp.next = new ListNode(tmp);
            }
            ltmp = ltmp.next;
            l1tmp = l1tmp.next;
            l2tmp = l2tmp.next;
        }
        if(l1tmp != null) {
            while (l1tmp != null) {
                int tmp = l1tmp.val + carry;
                if(tmp > 9) {
                    int v = tmp % 10;
                    carry = 1;
                    ltmp.next = new ListNode(v);
                } else {
                    carry = 0;
                    ltmp.next = new ListNode(tmp);
                }
                ltmp = ltmp.next;
                l1tmp = l1tmp.next;
            }
            if(carry == 1) {
                carry = 0;
                ltmp.next = new ListNode(1);
            }
        } else if(l2tmp != null) {
            while (l2tmp != null) {
                int tmp = l2tmp.val + carry;
                if(tmp > 9) {
                    int v = tmp % 10;
                    carry = 1;
                    ltmp.next = new ListNode(v);
                } else {
                    carry = 0;
                    ltmp.next = new ListNode(tmp);
                }
                ltmp = ltmp.next;
                l2tmp = l2tmp.next;
            }
            if(carry == 1) {
                carry = 0;
                ltmp.next = new ListNode(1);
            }
        }
        if(carry == 1) {
            ltmp.next = new ListNode(1);
        }
        return head.next;
    }
}
