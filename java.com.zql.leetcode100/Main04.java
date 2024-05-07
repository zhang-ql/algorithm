import java.util.*;
import java.util.stream.Stream;
public class Main04 {
    /*
     * 283. 移动零移动零
     * leetcode100 4
     * 输入: nums = [0,1,0,3,12]
     *输出: [1,3,12,0,0]
     *1 0 2 0 3
     *1 2 3 0 0
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
//        int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();//Arrays的数组工具类
        int[] nums = Stream.of(str).mapToInt(Integer::parseInt).toArray();//静态工厂
        new Main04().moveZeros(nums);
//        Arrays.stream(nums).forEach(System.out::print);
        boolean isFirst = true;
        for (int num : nums) {
            if (!isFirst) {
                System.out.print(" ");
            }
            System.out.print(num);
            isFirst = false;
        }
    }

    private void moveZeros(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

}
