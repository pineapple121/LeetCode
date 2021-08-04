package leetcode;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code143 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        reorderList(l1);
        ListNode p = l1;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void reorderList(ListNode head) {
        //寻找中间端点，快慢指针
        ListNode middleNode = findMiddleNode(head);
        ListNode l1 = head;
        ListNode l2 = middleNode.next;
        middleNode.next = null;
        //翻转后半段链表
        middleNode = reverseList(l2);
        //合并前后两段链表
        mergeList(head, middleNode);
    }

    public static ListNode findMiddleNode(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pHead = new ListNode(-1);
        ListNode p = head;
        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = pHead.next;
            pHead.next = p;
            p = next;
        }
        return pHead.next;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

}
