class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> subPuzzles = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            subPuzzles.add(new HashSet<>());
        }

        for (int x = 0; x < 9; x++) {
            Set<Character> rowFound = new HashSet<>();
            Set<Character> colFound = new HashSet<>();
            for (int y = 0; y < 9; y++) {
                System.out.println("x,y: " + x + "," + y);
                System.out.println("board[x,y]: " + board[x][y]);

                if (board[x][y] != '.') {
                    if (colFound.contains(board[x][y])) {
                        return false;
                    } else {
                        colFound.add(board[x][y]);
                    }
                    System.out.println("colFound: " + colFound);

                    int subPuzzleIndex = 0;
                    if (x >= 6 && y >= 6) subPuzzleIndex = 8;
                    else if (x >= 6 && y >= 3 && y < 6) subPuzzleIndex = 7;
                    else if (x >= 6 && y >= 0 && y < 3) subPuzzleIndex = 6;
                    else if (x >= 3 && y >= 6) subPuzzleIndex = 5;
                    else if (x >= 3 && y >= 3 && y < 6) subPuzzleIndex = 4;
                    else if (x >= 3 && y >= 0 && y < 3) subPuzzleIndex = 3;
                    else if (x >= 0 && y >= 6) subPuzzleIndex = 2;
                    else if (x >= 0 && y >= 3 && y < 6) subPuzzleIndex = 1;
                    Set<Character> currentSubPuzzle = subPuzzles.get(subPuzzleIndex);
                    System.out.println("current subpuzzle(i): (" + subPuzzleIndex + ") " + currentSubPuzzle);
                    if (currentSubPuzzle.contains(board[x][y])) {
                        return false;
                    } else {
                        currentSubPuzzle.add(board[x][y]);
                    }
                }

                if (board[y][x] != '.') {
                    if (rowFound.contains(board[y][x])) {
                        return false;
                    } else {
                        rowFound.add(board[y][x]);
                    }
                    System.out.println("rowFound: " + rowFound);
                }
            }
        }
        return true;
    }
}
