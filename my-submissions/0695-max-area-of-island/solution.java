class Solution {

    

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int r = 0; r < grid.length; r ++){
            for(int c = 0; c < grid[r].length; c ++){
                if(grid[r][c] == 1){
                    
                    maxArea = Math.max(islandArea(grid,r,c), maxArea);
                }
            }
        }          
        return maxArea; 
    }

    private int islandArea(int[][] grid, int r , int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0) return 0;    
    
    
        grid[r][c] = 0;

        return 1 +
        islandArea(grid,r-1,c) +
        islandArea(grid,r+1,c) + 
        islandArea(grid,r,c-1) +
        islandArea(grid,r,c+1);
    }
}
