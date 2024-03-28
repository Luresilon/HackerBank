package Medium;

import java.util.*;

public class IsValidSudoku {
//    public static boolean isValidSudoku(String[][] board) {
//        Map<Integer, Set<Character>> cols = new HashMap<>();
//        Map<Integer, Set<Character>> rows = new HashMap<>();
//        Map<Integer, Set<Character>> squares = new HashMap<>();
//
//        for (int r = 0; r < 9; r++) {
//            for (int c = 0; c < 9; c++) {
//                char cell = board[r][c].charAt(0);
//                if (cell == '.') {
//                    continue;
//                }
//
//                if (rows.containsKey(r) && rows.get(r).contains(cell) ||
//                        cols.containsKey(c) && cols.get(c).contains(cell) ||
//                        squares.containsKey(3 * (r / 3) + (c / 3)) && squares.get(3 * (r / 3) + (c / 3)).contains(cell)) {
//                    return false;
//                }
//
//                cols.computeIfAbsent(c, k -> new HashSet<>()).add(cell);
//                rows.computeIfAbsent(r, k -> new HashSet<>()).add(cell);
//                squares.computeIfAbsent(3 * (r / 3) + (c / 3), k -> new HashSet<>()).add(cell);
//            }
//        }
//
//        return true;
//    }

    public static boolean isValidSudoku(String[][] board) {
    HashSet<String> seen = new HashSet<>();
    System.out.println((float) 1/3);
    System.out.println(1/3);
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j].charAt(0);
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
}


public static boolean isValidSudoku2(final String[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char number = board[i][j].charAt(0);
                if(number != '.') {
                    if(!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + "in square " + i/3 + "-" + j/3)) return false;
                }
            }
        }
        return true;
}

















    public static void main(String[] args) {
        String[][] board = {{"5","3",".",".","7",".",".",".","."}
            ,{"6",".",".","1","9","5",".",".","."}
            ,{".","9","8",".",".",".",".","6","."}
            ,{"8",".",".",".","6",".",".",".","3"}
            ,{"4",".",".","8",".","3",".",".","1"}
            ,{"7",".",".",".","2",".",".",".","6"}
            ,{".","6",".",".",".",".","2","8","."}
            ,{".",".",".","4","1","9",".",".","5"}
            ,{".",".",".",".","8",".",".","7","9"}};

        boolean isValid = isValidSudoku2(board);
        System.out.println(isValid);
    }
}
