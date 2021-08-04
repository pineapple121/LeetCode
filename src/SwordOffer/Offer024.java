package SwordOffer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Offer024 {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode pHead=new ListNode(-1);
        ListNode p=head.next;
        pHead.next=head;
        head.next=null;
        while(p!=null){
            ListNode next=p.next;
            p.next=pHead.next;
            pHead.next=p;
            p=next;
        }
        return pHead.next;
    }
}
   class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }