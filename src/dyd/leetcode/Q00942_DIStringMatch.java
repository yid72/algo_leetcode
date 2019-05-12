package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 *
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 *
 * Example 1:
 *
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 *
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 *
 * Input: "DDI"
 * Output: [3,2,0,1]
 *
 *
 * Note:
 *
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 */
public class Q00942_DIStringMatch {
    public int[] diStringMatch(String S) {
        int low = 0;
        int high = S.length();
        int[] result = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                result[i] = low ++;
            } else {
                result[i] = high --;
            }
        }
        result[S.length()] = low;
        return result;
    }

    public static void main(String[] args) {
        Q00942_DIStringMatch q = new Q00942_DIStringMatch();
        PrintUtil.printArray(q.diStringMatch("IDID"));
        PrintUtil.printArray(q.diStringMatch("III"));
        PrintUtil.printArray(q.diStringMatch("DDI"));
    }
}
