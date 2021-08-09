package leetcode;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code025 {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        reverseKGroup(p1, 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode pHead = new ListNode(-1);
        pHead.next = null;
        ListNode p = head;
        ListNode next;
        ListNode pre = pHead;
        ListNode reversePoint = p;
        int n = k;
        while (p != null) {
            next = p.next;
            p.next = pre.next;
            pre.next = p;
            n--;
            if (n == 0) {
                n = k;
                pre = reversePoint;
                reversePoint = next;
            }
            p = next;

        }
        //将最后一组数量不到k的节点再反转过来
        if (n != 0) {
            p = pre.next;
            pre.next = null;
            while (p != null) {
                next = p.next;
                p.next = pre.next;
                pre.next = p;
                p = next;
            }
        }
        return pHead.next;
    }
}
