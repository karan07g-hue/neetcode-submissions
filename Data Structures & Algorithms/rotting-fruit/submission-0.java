class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                } else if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                for(int[] d : dirs){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
