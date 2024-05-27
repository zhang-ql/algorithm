import java.util.*;

public class Main16 {

    //除自身以外数组的乘积
    //输入: nums = [1,2,3,4]
    //输出: [24,12,8,6]


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(",");
        int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        int[] arr1 = new Main16().productExceptSelf(arr);
        boolean isFirst = true;
        for (int i : arr1) {
            if (!isFirst) System.out.print(" ");
            System.out.print(i);
            isFirst = false;
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * suf[i];
        }
        return ans;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        suf[n-1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = nums[i+1]*suf[i+1];
        }
        int pre = 1;
        for (int i = 0; i < n; i++) {
            suf[i] *= pre;
            pre *= nums[i];
        }
        return suf;
    }

}
