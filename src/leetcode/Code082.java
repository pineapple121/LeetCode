package leetcode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode pHead = new ListNode(0);
        ListNode pre = pHead;
        ListNode p = head, next;
        while (p != null) {
            next = p.next;
            if (next == null) {
                pre.next = p;
                pre = p;
                p = next;
            } else if (p.val != next.val) {
                pre.next = p;
                pre = p;
                p = next;
            } else {
                while (next != null && p.val == next.val) {
                    next = next.next;
                }
                p = next;
            }
        }
        pre.next = p;
        return pHead.next;
    }
}
