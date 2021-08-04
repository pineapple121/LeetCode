package SwordOffer;

import java.util.*;

/**
 * 剑指 Offer 41. 数据流中的中位数
 *
 * 思路：
 *  用一个大顶堆，一个小顶堆来保存元素，大顶堆保存较小的一半，小顶堆保存较大的一半
 *  假设小顶堆为A,大顶堆为B，其长度分别为m和n，
 *  则当m=n时，可以将新加入的数据插入较大的一半数据中，即插入小顶堆A中
 *  具体做法是先将数据插入大顶堆B中，然后调整B，将堆顶的元素再插入A中，这样能保证A中的数据比B中所有的数据都大
 *
 *  当m！=n时，大顶堆B中的数量较少，此时可以将数据插入B中，具体做法是先将数据插入小顶堆A中，调整A，将堆顶元素插入B中，也是为了保证A中所有数据
 *  都比B中的大。
 */
public class Offer041 {
    Queue<Integer> A,B;
    public Offer041() {
        //小顶堆,保存较大的一半元素
        A=new PriorityQueue<>();
        //大顶堆，保存较小的一半元素
//        B=new PriorityQueue<>((x,y)->(y-x));
        B=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }


    public void addNum(int num) {
        int m=A.size();
        int n=B.size();
        if(m==n){
            B.add(num);
            A.add(B.remove());
        }else{
            A.add(num);
            B.add(A.remove());
        }
    }

    public double findMedian() {
        int m=A.size();
        int n=B.size();
        if(m==n){
            return  (A.peek().doubleValue()+B.peek().doubleValue())/2.0;
        }else{
            return A.peek().doubleValue();
        }
    }
}
