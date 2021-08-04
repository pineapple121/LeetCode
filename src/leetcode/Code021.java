package leetcode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Code021 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pHead=new ListNode(-1);
        ListNode p=pHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        while(l1!=null){
            p.next=l1;
            p=p.next;
            l1=l1.next;
        }
        while(l2!=null){
            p.next=l2;
            p=p.next;
            l2=l2.next;
        }
        return pHead.next;
    }
}
