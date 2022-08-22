package cn.com.uestc.utils;

public class BinSearchUtil {

    private final static int INT_START = 0;

    private final static int INT_END = 31;

    // pow of 2, 2^0 ~ 2 ^ 31 - 1
    private final static int[] INT_HAF_ARR = new int[]{
            1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
            4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608,
            16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483647};

    /**
     * 二分算法,查询二进制数的长度
     * @param bin
     * @return
     */
    public static int intLength(int bin) {
        var left = INT_START;
        var right = INT_END;

        while (left <= right) {
//            防溢出处理(即便当前情况不可能溢出)
            var mid = left / 2 + right / 2;
//            当前数与中数比较
            if (INT_HAF_ARR[mid] <= bin) {
                if (INT_HAF_ARR[mid + 1] > bin)
                    return mid + 1; // got it!
                else // powof2[mid] < n, search right part
                    left = mid + 1;
            } else // powof2[mid] > n, search left part
                right = mid - 1;
        }
        // not found
        return -1;
    }
}
