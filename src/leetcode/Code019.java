package leetcode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 思路：、
 * 使用快慢指针，快指针先走n步，然后快慢指针同时走，当快指针到达链表尾端时，
 * 慢指针所指的位置即为要删除的节点
 */
public class Code019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 2; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        ListNode result = removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode fast = node;
        ListNode slow = node;
        while (n > 0 && node.next != null) {
            fast = node.next;
            node = node.next;
            n--;
        }
        //n>0代表要删除头节点
        if (n > 0) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode deleteNode = slow.next;
        slow.next = deleteNode.next;


        return head;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode pre = hair, p = head, fast = head, slow = head;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if (n > 0) {
            return head;
        }
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        //删除倒数第n个节点
        pre.next = slow.next;
        return hair.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}