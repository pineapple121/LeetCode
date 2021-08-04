package SwordOffer;
//合并两个排序的链表
public class Offer025 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(-1);
        ListNode l3=ans;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                l3.next=l1;
                l1=l1.next;
            }else{
                l3.next=l2;
                l2=l2.next;
            }
            l3=l3.next;
        }
        if(l1!=null){
            l3.next=l1;
        }
        else{
            l3.next=l2;
        }
        return ans.next;
    }
}
