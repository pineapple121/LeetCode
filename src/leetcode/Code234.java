package leetcode;

/**
 * 请判断一个链表是否为回文链表。
 * 思路：
 * 先利用快慢指针找到链表的中间节点。然后把后半部分链表翻转，
 * 接着从头开始比较两段链表是否相等
 */
public class Code234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        reverseLink(slow);
        ListNode l1=head;
        ListNode l2=slow.next;
        while(l2!=null){
            if(l1.val==l2.val){
                l1=l1.next;
                l2=l2.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public void reverseLink(ListNode head){
        ListNode p=head.next;
        ListNode next;
        head.next=null;
        while(p!=null){
            next=p.next;
            p.next=head.next;
            head.next=p;
            p=next;

        }
    }
}
