package SwordOffer;

/**
 * 删除链表的节点
 * <p>
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class Offer018 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return head;
        if (head.val == val)
            return head.next;
        ListNode p = head.next;
        ListNode pre = head;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                return head;
            }
            pre = p;
            p = p.next;
        }
        return head;
    }

    public ListNode deleteNode02(ListNode head, int val) {
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode pre = hair;
        ListNode p = head;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                return hair.next;
            }
            pre = p;
            p = p.next;
        }
        return hair.next;
    }
}
