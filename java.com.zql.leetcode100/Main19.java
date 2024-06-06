import java.util.*;

public class Main19 {
//https://leetcode.cn/problems/spiral-matrix/solutions/4317/luo-xuan-ju-zhen-by-liao-tian-yi-jian/?envType=study-plan-v2&envId=top-100-liked
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    //
    public static void main(String[] args) {

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        //定义一个存储结果的变量。
        List<Integer> list = new ArrayList<>();
        //为空时，直接退出。
        if(matrix ==null || matrix.length ==0){
            return list;
        }
        //构造一个 m*n 的一个矩阵
        int m = matrix.length; //行
        int n = matrix[0].length; //列
        int i =0;  //层数(从外向内的层数)
        int count = (Math.min(m,n)+1)/2; //统计从外向内的总层数，至少为一层
        while(i<count){
            //从左往右
            //行不变，列逐渐增大，特被这里 n-i是为了控制他在从外到内，第几层。最外面为第0层
            // j 为变化的列
            for(int j = i;j<n-i;j++){
                list.add(matrix[i][j]);
            }
            //从上往下
            //行逐渐增大，列不变
            // j 为变化的行
            // （n-1）-i 为最右边一列
            for(int j = i+1;j<m-i;j++){
                list.add(matrix[j][(n-1)-i]);
            }
            //从右往左
            //行不变，列逐渐减小
            // j 为变化的列
            // （n-1）-(i+1) 这里的 i + 1是为了去除最右下角那个数，
            // n-1-i 指向最右边的列， j >= i 是为了保证当行为最后一行
            //这里的 (n-1-i) != i 这是用来保证，是属于同一层的
            for(int j= (n-1)-(i+1); j>= i && (m-1-i != i); j--){
                list.add(matrix[(m-1)-i][j]);
            }
            //从下往上
            //列不变，行逐渐减小
            // j 为可变的行
            //(m-1)-(i+1) 是为了去除最左上角的数
            // j >= i+1，是为了保证当前行为第二行
            // (n-1-i) !=i 这是用来保证，是属于同一层的。
            for(int j = (m-1)-(i+1);j >= i+1 && (n-1-i) !=i; j--){
                list.add(matrix[j][i]);
            }
            i++; //层数加一，继续向内层递进
        }
        //返回结果
        return list;
    }

}
