package dyd.leetcode;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;
import dyd.leetcode.common.PrintUtil;

/**
 * 86. Partition List -- Medium
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 */
public class Q00086_PartitionList {
    public ListNode partition(ListNode head, int x) {
    	ListNode lowHead = null, lowCur = null, highHead = null, highCur = null;
    	
    	ListNode cur = head;
    	while (cur != null) {
    		ListNode next = cur.next;
    		
    		cur.next = null;
    		
    		if (cur.val < x) {
    			if (lowHead == null) {
    				lowHead = cur;
    				lowCur = cur;
    			}
    			else {
    				lowCur.next = cur;
    				lowCur = cur;
    			}
    		}
    		else {
    			if (highHead == null) {
    				highHead = cur;
    				highCur = cur;
    			}
    			else {
    				highCur.next = cur;
    				highCur = cur;
    			}
    		}
    		
    		cur = next;
    	}
    	
    	if (lowCur != null) {
    		lowCur.next = highHead;
    		return lowHead;
    	}
    	
    	return highHead;
    }
    
    public static void main(String[] args) {
    	Q00086_PartitionList q = new Q00086_PartitionList();
    	ListNode head = ListUtil.createList(new int[] {1, 4, 3, 2, 5, 2});
    	System.out.print("Original list: ");
    	PrintUtil.printList(head);
    	
    	System.out.println("Value: 3");
    	
    	head = q.partition(head, 3);
    	PrintUtil.printList(head);
    }
}
