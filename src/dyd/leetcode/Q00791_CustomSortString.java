package dyd.leetcode;

/**
 * 791. Custom Sort String -- Medium
 * 
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 *
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 *
 * Return any permutation of T (as a string) that satisfies this property.
 *
 * Example :
 * Input: 
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation: 
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 *
 *
 * Note:
 *
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only
 */
public class Q00791_CustomSortString {
    public String customSortString(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return T;
        }

        int[] tCharCounts = new int[26];
        for (int i = 0; i < T.length(); i++) {
            tCharCounts[T.charAt(i) - 'a'] ++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            for (int j = 0; j < tCharCounts[ch - 'a']; j++) {
                sb.append(ch);
            }

            tCharCounts[ch - 'a'] = 0;
        }

        for (int i = 0; i < tCharCounts.length; i++) {
            for (int j = 0; j < tCharCounts[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }

        return sb.toString();
     }

     public static void main(String[] args) {
        test("cba", "abcd");
     }

     private static void test(String S, String T) {
         Q00791_CustomSortString q = new Q00791_CustomSortString();
        System.out.printf("S=%s, T=%s: %s\n", S, T, q.customSortString(S, T));
     }
}
