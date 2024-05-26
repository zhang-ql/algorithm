import java.util.Arrays;
import java.util.Scanner;
//最大字数和，使用前缀和，接合题目找preSum和minPreSum
public class Main13 {
    //最大子数组和
    //https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
    //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    //输出：6
    //
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] arr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        int res = new Main13().maxSubArray1(arr);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return nums[0];
        int count = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            count += nums[i];
            sum = Math.max(sum, count);
            if (count < 0) {
                count = 0;
            }
        }
        return sum;
    }

    //使用前缀和
    public int maxSubArray1(int[] nums) {
        int ans = 0;
        int preSum = 0;
        int minPreSum = 0;
        for (int x : nums) {
            preSum += x;
            ans = Math.max(ans, preSum - minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
        }
        return ans;
    }
}
