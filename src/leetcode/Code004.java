package leetcode;

/**
 * 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 思路：
 * 三种情况：
 * 如果 \text{A}[k/2-1] < \text{B}[k/2-1]A[k/2−1]<B[k/2−1]，则比 \text{A}[k/2-1]A[k/2−1] 小的数最多只有 \text{A}A 的前 k/2-1k/2−1 个数和 \text{B}B 的前 k/2-1k/2−1 个数，即比 \text{A}[k/2-1]A[k/2−1] 小的数最多只有 k-2k−2 个，因此 \text{A}[k/2-1]A[k/2−1] 不可能是第 kk 个数，\text{A}[0]A[0] 到 \text{A}[k/2-1]A[k/2−1] 也都不可能是第 kk 个数，可以全部排除。
 * <p>
 * 如果 \text{A}[k/2-1] > \text{B}[k/2-1]A[k/2−1]>B[k/2−1]，则可以排除 \text{B}[0]B[0] 到 \text{B}[k/2-1]B[k/2−1]。
 * <p>
 * 如果 \text{A}[k/2-1] = \text{B}[k/2-1]A[k/2−1]=B[k/2−1]，则可以归入第一种情况处理。
 * <p>
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Code004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        if (totalLen % 2 == 1) {
            return findKMinNum(nums1, nums2, totalLen / 2 + 1);
        } else {
            //由于求第k小，所以下标应当都+1；
            //本来的要求的数组下标为totalLen/2-1和totalLen/2;
            return (findKMinNum(nums1, nums2, totalLen / 2) + findKMinNum(nums1, nums2, totalLen / 2 + 1)) / 2.0;
        }
    }

    public double findKMinNum(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
