package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

import java.util.Arrays;

/**
 * You have some apples, where arr[i] is the weight of the i-th apple.  You also have a basket that can carry up to 5000 units of weight.
 *
 * Return the maximum number of apples you can put in the basket.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [100,200,150,1000]
 * Output: 4
 * Explanation: All 4 apples can be carried by the basket since their sum of weights is 1450.
 * Example 2:
 *
 * Input: arr = [900,950,800,1000,700,800]
 * Output: 5
 * Explanation: The sum of weights of the 6 apples exceeds 5000 so we choose any 5 of them.
 */
public class Q01196_HowManyApplesCanYouPutIntoTheBasket {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > 5000) {
                return i;
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {
        test(new int[] {100,200,150,1000});
        test(new int[] {900,950,800,1000,700,800});
    }

    private static void test(int[] arr) {
        PrintUtil.printArray(arr);
        Q01196_HowManyApplesCanYouPutIntoTheBasket q = new Q01196_HowManyApplesCanYouPutIntoTheBasket();
        System.out.println("max number: " + q.maxNumberOfApples(arr));
    }
}
