package leetcode;

import java.util.Random;

/**
 * @program: LeetCode
 * @Description: 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * @Author: Marco
 * @Date: 2021-08-11 16:14
 **/

public class Code470 {
    public int rand10() {
        int row, column, index;
        do {
            row = rand7();
            column = rand7();
            index = (row - 1) * 7 + column;
        } while (index > 40);
        return 1 + (index - 1) % 10;

    }

    private int rand7() {
        Random r = new Random();
        return r.nextInt(7) + 1;
    }
}
