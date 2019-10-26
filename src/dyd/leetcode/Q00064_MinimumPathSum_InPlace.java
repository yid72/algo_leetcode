package dyd.leetcode;

public class Q00064_MinimumPathSum_InPlace {
    public int minPathSum(int[][] grid) {
    	if (grid.length == 0) {
    		return 0;
    	}
    	
    	for (int i = 0; i < grid.length; i ++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (i == 0 && j == 0) {
    				continue;
    			}
    			
    			int top = Integer.MAX_VALUE;
    			if (i > 0) {
    				top = grid[i-1][j];
    			}
    			
    			int left = Integer.MAX_VALUE;
    			if (j > 0) {
    				left = grid[i][j-1];
    			}
    			
    			grid[i][j] += Math.min(top, left);
    		}
    	}
    	
    	return grid[grid.length - 1][grid[0].length - 1];
    }
}
