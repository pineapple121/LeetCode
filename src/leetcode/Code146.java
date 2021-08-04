package leetcode;

import java.util.HashMap;

/**
 *
 *  LRU(最近最少使用) 缓存机制
 *  思路：
 *  利用一个双向链表存储缓存，新加入的放在链表头，淘汰时从链表尾进行淘汰
 *  再利用一个HashMap存储Key和链表节点的键值对，能够在O（1）的时间内快速找到某个节点
 */
public class Code146 {
    class LRUCache{
        private HashMap<Integer,DoubleLinkedNode>map=new HashMap<>();
        private DoubleLinkedNode head,tail;
        private int capacity;
        private int size;
        public LRUCache(int capacity) {
            this.capacity=capacity;
            this.size=0;
            head=new DoubleLinkedNode(-1,-1);
            tail=new DoubleLinkedNode(-1,-1);
            head.next=tail;
            tail.pre=head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                DoubleLinkedNode node=map.get(key);
                node.pre.next=node.next;
                node.next.pre=node.pre;

                moveToHead(node);
                return node.value;
            }
            return -1;

        }

        public void put(int key, int value) {
            //缓存中存在，直接更新，并将其移动到头结点后
            if(map.containsKey(key)){
                DoubleLinkedNode node=map.get(key);
                node.value=value;
                node.pre.next=node.next;
                node.next.pre=node.pre;
                moveToHead(node);
            }else{
                //不存在，新建一个节点加入链表
                DoubleLinkedNode node=new DoubleLinkedNode(key,value);
                //需要先将最后一个元素淘汰掉
                if(this.size==this.capacity){
                    DoubleLinkedNode delete=tail.pre;
                    delete.pre.next=delete.next;
                    delete.next.pre=delete.pre;
                    map.remove(delete.key);
                    this.size--;
                }
                //放在头结点后，证明是最近用到的
                moveToHead(node);
                map.put(key,node);
                this.size++;
            }


        }
        public void moveToHead(DoubleLinkedNode node){
            head.next.pre=node;
            node.pre=head;
            node.next=head.next;
            head.next=node;
        }
    }
    class DoubleLinkedNode{
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
        public DoubleLinkedNode(){}
        public DoubleLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
}
