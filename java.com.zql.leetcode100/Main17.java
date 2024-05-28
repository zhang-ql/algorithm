import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main17 {
    //  缺失的第一个正数
    //输入：nums = [3,4,-1,1]
    //输出：2
    //解释：1 在数组中，但 2 没有。
    //
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arrStr = in.nextLine().split(",");
        int[] arr = Arrays.stream(arrStr).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Main17().firstMissingPositive(arr));
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) hashSet.add(num);
        for (int i = 0; i < len; i++) {
            if (!hashSet.contains(i + 1)) return i+1;
        }
        return len + 1;
    }


    public int firstMissingPositive1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while(nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) swap(nums, nums[i]-1, i);
        }

        //[1, -1, 3 , 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0 && nums[i] <= n) map[nums[i] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (map[i] == 0) return i+1;
        }
        return n+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
