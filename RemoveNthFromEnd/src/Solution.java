
//  Given a linked list, remove the Nth node from the end of list and return its head.
/*  conditions:Given n will always be valid.Try to do this in one pass.
* */
class ListNode {
    int val;
    ListNode next;
    ListNode (int x) { val = x; }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode p = vhead;
        ListNode q = vhead;
        if(head == null && head.next == null) return null;
        for(int i = 0; i < n; ++ i){
            q = q.next;
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return vhead.next;
    }

    ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode p = vhead;
        ListNode q = vhead;
        if(head == null && head.next == null) return null;
        int i = 0;
        while (q.next != null){
            q = q.next;
            i++;
            if(i > n){
                p = p.next;
            }
        }
        p.next = p.next.next;
        return vhead.next;
    }
    //Recursion
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        remove(newhead,n);
        return newhead.next;
    }

    private int remove(ListNode node, int n) {
        if(node.next == null) return 1; //end is the first level
        int level = remove(node.next,n)+1;
        if(level == n+1)    //find the parent node
            node.next = node.next.next;
        return level;
    }
}
