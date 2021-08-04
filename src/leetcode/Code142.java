package leetcode;

/**
 * 142. 环形链表 II
 * 如果有环，找到环的入口节点
 *
 */
public class Code142 {
    public static void main(String[] args) {
        //[3,2,0,-4]
        ListNode p1=new ListNode(3);
        ListNode p2=new ListNode(2);
        ListNode p3=new ListNode(0);
        ListNode p4=new ListNode(-4);
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p2;
        ListNode p=detectCycle(p1);
        if(p!=null)
            System.out.println(p.val);

    }
    public static ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast !=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                break;
        }
        if(fast==slow){
            ListNode p=head;
            while(p!=slow){
                p=p.next;
                slow=slow.next;
            }
            return p;
        }
        return null;
    }
}
