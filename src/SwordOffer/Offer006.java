package SwordOffer;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 思路：
 * 先将链表翻转，翻转的同时记录节点的个数
 * new一个int数组，再从头到尾遍历链表，将节点的值加入数组
 */
public class Offer006 {
    public int[] reversePrint(ListNode head) {
        ListNode pHead=new ListNode(-1);
        int length=0;
        ListNode p=head;
        ListNode next;
        //翻转链表，并统计节点个数
        while(p!=null){
            next=p.next;
            p.next=pHead.next;
            pHead.next=p;
            p=next;
            length++;
        }
        int[] ans=new int[length];
        p=pHead.next;
        int i=0;
        while(p!=null){
            ans[i]=p.val;
            p=p.next;
            i++;
        }
        return ans;
    }
}
