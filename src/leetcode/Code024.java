package leetcode;

/**
 * @program: LeetCode
 * @Description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @Author: Marco
 * @Date: 2021-08-07 16:08
 **/

public class Code024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        //创建一个前置节点，方便反转头结点,存储已经反转过后的最后一个节点
        ListNode pre = new ListNode(-1);
        ListNode pHead = pre;
        pre.next = head;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            //当next为空时，证明current已经为最后一个节点，不需要反转，直接返回
            if (next == null) {
                return pHead.next;
            }
            //temp存储剩下还没有反转的链表的第一个节点
            ListNode temp = next.next;
            //开始反转
            pre.next = next;
            next.next = current;
            current.next = temp;
            pre = current;
            current = temp;
        }
        return pHead.next;
    }
}
