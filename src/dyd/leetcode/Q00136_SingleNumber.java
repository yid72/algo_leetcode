package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

public class Q00136_SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[] {2, 2, 3, 1, 3};
        PrintUtil.printArray(data);

        Q00136_SingleNumber q = new Q00136_SingleNumber();
        System.out.println(q.singleNumber(data));
    }
}