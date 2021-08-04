package leetcode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 思路：
 * 分治合并
 * 遍历链表，两两合并；
 */
public class Code023 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right)
            return null;
        int mid = (left + right) >> 1;
        return Code021.mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    // * 遍历链表，两两合并；
//    public ListNode mergeKLists(ListNode[] lists) {
//        int length = lists.length;
//        if(length==0)
//            return null;
//        if(length==1)
//            return lists[0];
//        ListNode ans=lists[0];
//        int i=1;
//        while(i<=length){
//            //合并两个升序链表
//            ans=Code021.mergeTwoLists(ans,lists[i]);
//            i++;
//        }
//        return ans;
//
//    }
}
