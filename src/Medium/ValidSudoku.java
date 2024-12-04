package Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

//Leetcode problem: 36
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int len = board.length;
        Set<String> res = new HashSet<>();

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                char str = board[i][j];
                if(Objects.equals(str, '.')) continue;
                String row = str + " in row " + i;
                String col = str + " in col " + j;
                String subBox = str + " in sub-box " + i / 3 + " " + j / 3;

                if(res.contains(row) || res.contains(col) || res.contains(subBox)) return false;
                res.addAll(List.of(row, col, subBox));
            }
        }
        return true;
    }
//    public static void main(String[] args) {
//        char[][] board =     {{'5',"3",".",".","7",".",".",".","."},
//                                {"6",".",".","1","9","5",".",".","."},
//                                {".","9","8",".",".",".",".","6","."},
//                                {"8",".",".",".","6",".",".",".","3"},
//                                {"4",".",".","8",".","3",".",".","1"},
//                                {"7",".",".",".","2",".",".",".","6"},
//                                {".","6",".",".",".",".","2","8","."},
//                                {".",".",".","4","1","9",".",".","5"},
//                                {".",".",".",".","8",".",".","7","9"}};
//        System.out.println(isValidSudoku(board));
//    }
}
