class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        char[][] b = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = '.';
            }
        }
        solve(solution, b, 0, n);
        return solution;
    }

    private void solve(List<List<String>> solution, char[][] b, int row, int n) {
        if (row == n) {
            solution.add(createBoard(b, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(b, row, col, n)) {
                b[row][col] = 'Q';
                solve(solution, b, row + 1, n);
                b[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] b, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (b[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (b[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (b[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> createBoard(char[][] b, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new String(b[i]));
        }
        return res;
    }
}