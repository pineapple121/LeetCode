package leetcode;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 */
public class Code083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode p = head, next;
        while (p != null) {
            next = p.next;
            while (next != null && p.val == next.val) {
                next = next.next;
            }
            p.next = next;
            p = next;
        }
        return head;
    }
}
