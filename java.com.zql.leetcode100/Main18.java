import java.util.*;

public class Main18 {
    //输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
    //输出：[[1,0,1],[0,0,0],[1,0,1]]
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int[] k = list.get(i);
            setZero(matrix, k[0], k[1]);
        }
    }

    private void setZero(int[][] matrix, int i, int j) {
        for(int m = 0; m < matrix[0].length; m++) matrix[i][m] = 0;
        for(int n = 0; n < matrix.length; n++) matrix[n][j] = 0;
    }

    public void setZeroes1(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // 1. 扫描「首行」和「首列」记录「首行」和「首列」是否该被置零
        boolean r0 = false, c0 = false;
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 0) {
                r0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 0) {
                c0 = true;
                break;
            }
        }
        // 2.1 扫描「非首行首列」的位置，如果发现零，将需要置零的信息存储到该行的「最左方」和「最上方」的格子内
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 0) mat[i][0] = mat[0][j] = 0;
            }
        }
        // 2.2 根据刚刚记录在「最左方」和「最上方」格子内的置零信息，进行「非首行首列」置零
        for (int j = 1; j < n; j++) {
            if (mat[0][j] == 0) {
                for (int i = 1; i < m; i++) mat[i][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            if (mat[i][0] == 0) Arrays.fill(mat[i], 0);
        }
        // 3. 根据最开始记录的「首行」和「首列」信息，进行「首行首列」置零
        if (r0) for (int i = 0; i < m; i++) mat[i][0] = 0;
        if (c0) Arrays.fill(mat[0], 0);
    }
}
