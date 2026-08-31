class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int r = 0; r < grid.length ; r ++){
            for(int c = 0; c < grid[r].length; c ++ ){
                if(grid[r][c] == '1'){
                    count ++; 
                    sinkIsland(grid, r, c);
                }
            }

        }
        return count; 
    }

    private void sinkIsland(char[][] grid,int r, int c){
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0' ){
            return;
            }
            grid[r][c] = '0';

            sinkIsland(grid,r - 1,c );
            sinkIsland(grid,r + 1,c );
            sinkIsland(grid,r,c - 1 );
            sinkIsland(grid,r,c + 1 );
        
    }
}
