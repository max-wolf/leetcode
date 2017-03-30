
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode head1 = head;
        ListNode head2 = getMid(head);
        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1, head2);
    }

    ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tmp.next = head1;
                head1 = head1.next;
            }
            else {
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        if(head1 != null)
            tmp.next = head1;
        if(head2 != null)
            tmp.next = head2;
        return head.next;
    }

    ListNode getMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head.next;
        ListNode tmp = head;
        while (true) {
            fast = fast.next;
            if(fast != null) fast = fast.next;
            else break;
            if(fast == null) break;
            tmp = tmp.next;
            slow = slow.next;
        }
        tmp.next = null;
        return slow;
    }
}
