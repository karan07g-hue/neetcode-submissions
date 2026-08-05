class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[ 2 * n];
        int[] queens = new int[n];

        backtrack(0, n, queens, cols, diag1, diag2, result);
        return result;
    }
    private void backtrack(int row, int n, int[] queens, boolean[] cols, boolean[] diag1, boolean[] diag2, List<List<String>> result){
        if(row == n){
            result.add(buildBoard(queens, n));
            return;
        }
        for(int col = 0; col < n; col++){
            if(cols[col]) continue;
            if(diag1[row - col + n]) continue;
            if(diag2[row + col]) continue;
        
        queens[row] = col;
        cols[col] = true;
        diag1[row - col + n] = true;
        diag2[row + col] = true;

        backtrack(row + 1, n, queens, cols, diag1, diag2, result);

        cols[col] = false;
        diag1[row - col + n] = false;
        diag2[row + col] = false;

        }
    }
    private List<String> buildBoard(int[] queens, int n){
        List<String> board = new ArrayList<>();
        for(int row = 0; row < n; row++){
            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[queens[row]] = 'Q';
            board.add(new String(line));
        }
        return board;
    }
}
