package leetcode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Code206 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode pHead = new ListNode(-1);
//        pHead.next=head;
        ListNode p=head;
        ListNode next;
        while(p!=null){
            next=p.next;
            p.next=pHead.next;
            pHead.next=p;
            p=next;
        }
        return pHead.next;
    }
}
