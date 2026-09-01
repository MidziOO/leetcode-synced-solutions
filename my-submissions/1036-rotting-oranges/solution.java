class Solution {
    public int orangesRotting(int[][] grid) {
        
        int freshCount = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int r = 0; r < grid.length; r++ ){
            for(int c = 0; c < grid[r].length; c ++){
                if(grid[r][c] == 2 ){
                    queue.offer(new int[]{r,c});
                }
                else if(grid[r][c] == 1){
                    freshCount++;
                }    
            }
        }

        if(freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!queue.isEmpty() && freshCount > 0){
            int size = queue.size();

            for(int i = 0; i < size; i ++ ){
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                for(int j =0; j < directions.length; j++){
                    int newR = r + directions[j][0];
                    int newC = c + directions[j][1];
                    if(newR >= 0 && newR < grid.length && newC >=0 && newC < grid[0].length && grid[newR][newC] == 1 ){
                        grid[newR][newC] = 2; 
                        freshCount --;
                        queue.offer(new int[]{newR,newC}); 
                    }

                }
            }
            minutes++;
        } 
        if(freshCount == 0) return minutes;
        else return -1;  
    }
}
