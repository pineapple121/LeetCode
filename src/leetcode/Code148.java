package leetcode;

/**
 * 148. 排序链表
 */
public class Code148 {
    //自顶向下的递归，时间复杂度O(nlgn)，由于用到递归栈，空间复杂度O(lgn);
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null)
            return head;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


    //自底向上的归并排序，空间复杂度为O(1)
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        //计算链表的长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        //新建一个前置节点
        ListNode hair = new ListNode(-1);
        hair.next = head;
        //开始两两合并，length依次扩大两倍
        for (int subLength = 1; subLength < length; subLength = subLength * 2) {
            ListNode pre = hair, current = hair.next;
            //两两合并
            while (current != null) {
                //要合并的第n组的第一条链表
                ListNode head1 = current;
                //找到第n组第二条链表的头结点
                for (int i = 1; i < subLength && current.next != null; i++) {
                    current = current.next;
                }
                ListNode head2 = current.next;
                //第n组第一条链表尾的next指针置空
                current.next = null;
                current = head2;
                //找到第n组第二条链表的末尾，也是找到下一组第n+1组的头结点
                for (int i = 1; i < subLength && current != null && current.next != null; i++) {
                    current = current.next;
                }
                ListNode nextGroupFirstNode = null;
                if (current != null) {
                    //第n+1组第一条链表
                    nextGroupFirstNode = current.next;
                    //第n组第二条链表末尾置空
                    current.next = null;
                }
                //合并第n组两条链表
                ListNode merged = merge(head1, head2);
                pre.next = merged;
                //已合并的链表的末尾
                while (pre.next != null) {
                    pre = pre.next;
                }
                current = nextGroupFirstNode;
            }
        }
        return hair.next;
    }
}
