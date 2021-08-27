package SwordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @Description: 复杂链表的复制
 * @Author: Marco
 * @Date: 2021-08-27 11:39
 * <p>
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

public class Offer035 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        //建立原节点和新节点的映射
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        //构建指针指向
        p = head;
        while (p != null) {
            Node node = map.get(p);
            node.next = map.get(p.next);
            node.random = map.get(p.random);
            p = p.next;
        }
        //返回新节点
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
