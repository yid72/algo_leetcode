package dyd.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
 * are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class Q00200_Number_Of_Islands {
	private static class Position {
		int i;
		int j;
		
		public Position(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	private char[][] grid;
	
	private int[][] flags;
			
    public int numIslands(char[][] grid) {
    	if (grid == null || grid.length == 0) {
    		return 0;
    	}
    	
    	this.grid = grid;
    	int m = grid.length;
    	int n = grid[0].length;
    	
    	this.flags = new int[m][];
    	for (int i = 0; i < m; i++) {
    		this.flags[i] = new int[n];
    	}
        
        int curIsland = 0;
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == '1' && flags[i][j] == 0) {
//        			bfs(i, j, ++ curIsland);
        			dfs(i, j, ++ curIsland);
        		}
        	}
        }
        
        return curIsland;
    }
    
    private void bfs(int i, int j, int island) {
    	Queue<Position> queue = new LinkedList<Position>();
  		queue.add(new Position(i, j));
    	
    	while (!queue.isEmpty()) {
    		Position pos = queue.remove();
    		this.flags[pos.i][pos.j] = island;   		
  		
        	if (isUnvisitedLand(i - 1, j)) {
        		queue.add(new Position(i - 1, j));
        	}
        	
        	if (isUnvisitedLand(i + 1, j)) {
        		queue.add(new Position(i + 1, j));        	
        	}
        	
        	if (isUnvisitedLand(i, j - 1)) {
        		queue.add(new Position(i, j - 1));
        	}
        	
        	if (isUnvisitedLand(i, j + 1)) {
        		queue.add(new Position(i, j + 1));
        	} 
    	}
    }
    
    private void dfs(int i, int j, int island) {
    	this.flags[i][j] = island;
    	
    	if (isUnvisitedLand(i - 1, j)) {
    		dfs(i - 1, j, island);
    	}
    	
    	if (isUnvisitedLand(i + 1, j)) {
    		dfs(i + 1, j, island);
    	}
    	
    	if (isUnvisitedLand(i, j - 1)) {
    		dfs(i, j - 1, island);
    	}
    	
    	if (isUnvisitedLand(i, j + 1)) {
    		dfs(i, j + 1, island);
    	}    	
    }
    
    private boolean isUnvisitedLand(int i, int j) {
    	return (i >= 0 && i < this.grid.length &&
    			j >= 0 && j < this.grid[0].length &&
    			this.grid[i][j] == '1' && 
    			this.flags[i][j] == 0);
    }

    public static void main(String[] args) {
		Q00200_Number_Of_Islands t = new Q00200_Number_Of_Islands();

    	char[][] input1 = {
    			{'1', '1', '1', '1', '0'},
    			{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
    	};
    	System.out.println(t.numIslands(input1));

		char[][] input2 = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		System.out.println(t.numIslands(input2));
    }
}