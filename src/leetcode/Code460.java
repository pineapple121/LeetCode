package leetcode;

/**
 * @program: LeetCode
 * @Description: LFU 缓存
 * @Author: Marco
 * @Date: 2021-08-07 17:13
 **/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 思路：
 * 两个哈希表，一个哈希表存key和Node，Node里包含value,使用的频率frequency,
 * 另一个哈希表存key为frequency，值存一个Node链表，代表频率为某一值frequency的Node集合
 */
public class Code460 {
    class LFUCache {
        //容量
        int capacity;
        //最小使用频率
        int minFreq;
        //存key，Node
        Map<Integer, Node> key_table;
        //存frequency，相同使用频率的Node
        Map<Integer, LinkedList<Node>> freq_table;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.minFreq = 0;
            key_table = new HashMap<>();
            freq_table = new HashMap<>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            //先判断缓存中是否有这个key
            if (!key_table.containsKey(key)) {
                return -1;
            }
            //更新使用频率
            Node node = key_table.get(key);
            int freq = node.frequency;
            //先从频率为freq的链表中删除,此O(n)的时间复杂度
            freq_table.get(freq).remove(node);
            //如果当前链表为空，将空链表删除，节省空间
            if (freq_table.get(freq).size() == 0) {
                freq_table.remove(freq);
                //如果最小使用频率与当前节点使用频率相同，需要更新
                if (minFreq == freq) {
                    minFreq += 1;
                }
            }
            //将缓存插入到freq+1中，如果没有该频率则新建一个链表插入
            LinkedList<Node> list = freq_table.getOrDefault(freq + 1, new LinkedList<Node>());
            //插入头部，证明是最新插入的
            list.offerFirst(new Node(node.key, node.value, node.frequency + 1));
            freq_table.put(freq + 1, list);
            //更新key_table
            key_table.put(key, freq_table.get(freq + 1).peekFirst());
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            //先判断是否有该节点
            //有的话更新节点
            if (key_table.containsKey(key)) {
                Node node = key_table.get(key);
                //更新频率
                int freq = node.frequency;
                LinkedList<Node> list = freq_table.get(freq);
                list.remove(node);
                //没有该频率的节点了，删除链表
                if (list.size() == 0) {
                    freq_table.remove(freq);
                    //更新最小频率的节点
                    if (freq == minFreq) {
                        minFreq += 1;
                    }
                }
                list = freq_table.getOrDefault(freq + 1, new LinkedList<Node>());
                list.offerFirst(new Node(key, value, node.frequency + 1));
                freq_table.put(freq + 1, list);
                //更新key_table
                key_table.put(key, freq_table.get(freq + 1).peekFirst());
            }
            //没有节点需要新建
            else {
                //达到最大容量，需要淘汰缓存
                if (key_table.size() == capacity) {
                    //删除最小使用频率minFreq列表中的最后一个
                    LinkedList<Node> list = freq_table.get(minFreq);
                    Node deleteNode = list.peekLast();
                    key_table.remove(deleteNode.key);
                    list.pollLast();
                    //如果链表为空，删除
                    if (list.size() == 0) {
                        freq_table.remove(minFreq);
                    }
                }
                //将新节点加入频率为1的链表中
                LinkedList<Node> list = freq_table.getOrDefault(1, new LinkedList<>());
                list.offerFirst(new Node(key, value, 1));
                freq_table.put(1, list);
                key_table.put(key, freq_table.get(1).peekFirst());
                minFreq = 1;
            }
        }
    }

    class Node {
        int key, value, frequency;

        public Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
}
