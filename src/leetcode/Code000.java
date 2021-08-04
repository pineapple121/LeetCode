package leetcode;

public class Code000 {
    public static void main(String[] args) {
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode pre = pHead;
        ListNode p1 = head;
        ListNode p2 = head;
        while (n > 0 && p1 != null) {
            p1 = p1.next;
            n--;
        }
        while (p1 != null) {
            p1 = p1.next;
            pre = p2;
            p2 = p2.next;
        }
        pre.next = p2.next;
        return pHead.next;
    }
}
