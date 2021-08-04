package leetcode;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int l = 1;
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode pre = pHead;
        ListNode p = head;
        while (l < left) {
            pre = p;
            p = p.next;
            l++;
        }
        ListNode next;
        while (l < right) {
            next = p.next;
            p.next = next.next;
            next.next=pre.next;
            pre.next = next;
            l++;
        }
        return pHead.next;
    }
}
