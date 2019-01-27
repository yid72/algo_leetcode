package dyd.leetcode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 *
 */
public class Q00009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        
        int start = 0;
        if (start == '-') {
        	start ++;
        }
        
        int end = s.length() - 1;
        while (start <= end) {
        	if (s.charAt(start) != s.charAt(end)) {
        		return false;
        	}
        	start ++;
        	end --;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	Q00009_PalindromeNumber q = new Q00009_PalindromeNumber();
    	
    	System.out.println(q.isPalindrome(-2147483648));
    }
}
