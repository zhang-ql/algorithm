import java.util.Arrays;
import java.util.Scanner;

public class Main15 {
//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
    // nums = [1,2,3,4,5,6,7], k = 3
    //输出: [5,6,7,1,2,3,4]
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(",");
        int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        new Main15().rotate(arr, 3);
//        Arrays.stream(arr).forEach(System.out::println);
        boolean isFirst = true;
        for (int i : arr) {
            if (!isFirst) System.out.print(" ");
            System.out.print(i);
            isFirst = false;
        }
    }

    private void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
