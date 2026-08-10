class Solution {
    private static int INF = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        if(grid.length == 0 || grid == null) return;
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 0){
                    queue.offer(new int[] {r,c});
                }
            }
        }
        int[][] dirs = {{-1,0} , {1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == INF){
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
