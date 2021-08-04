package leetcode;

/**
 * 165. 比较版本号
 */
public class Code165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.1", "1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int index = 0;
        int len = Math.max(arr1.length, arr2.length);
        while (index < len) {
            String s1 = index < arr1.length ? arr1[index] : "0";
            String s2 = index < arr2.length ? arr2[index] : "0";
            int a1 = Integer.parseInt(s1);
            int a2 = Integer.parseInt(s2);
            if (a1 > a2)
                return 1;
            else if (a1 < a2)
                return -1;
            index++;
        }
        return 0;
    }
}
