class Solution {
    public boolean isValidSudoku(char[][] board) {
         for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                for(int k = j + 1; k < 9; k++){
                    if(board[i][j] != '.' && board[i][j] == board[i][k])
                    return false;
                }
            }
        }
        for(int j = 0; j < 9; j++){
            for(int i = 0; i < 9; i++){
                for(int k = i + 1; k < 9; k++){
                    if(board[i][j] != '.' && board[i][j] == board[k][j])
                    return false;
                }
                
            }
        }

        for(int boxRow = 0; boxRow < 3; boxRow++){
            for(int boxColumn = 0; boxColumn < 3; boxColumn++){
                char[] cells = new char[9];
                int idx = 0;
                for(int i = boxRow * 3; i < boxRow * 3 + 3; i++){
                    for(int j = boxColumn * 3; j < boxColumn * 3 + 3; j++){
                        cells[idx++] = board[i][j];
                    }
                }

                for(int a = 0; a < 9; a++){
                    for(int b = a + 1; b < 9; b++){
                        if(cells[a] != '.' && cells[a] == cells[b]) return false;
                    }
                }
            }
        }
        return true;
    }
}
