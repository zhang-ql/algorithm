import java.util.Arrays;
import java.util.Scanner;
//https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked

/**
 *[1,8,6,2,5,4,8,3,7]
 *
 *49
 */
public class Main05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(",");
        int[] array = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(array).forEach(System.out::println);
        int res = new Main05().maxArea(array);
        System.out.print(res);
    }

    private int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            res = height[left] < height[right] ?
                    Math.max(res, (right - left)) * height[left++] :
                    Math.max(res, (right - left) * height[right--]);
        }
        return res;
    }
}
