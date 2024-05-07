
import java.util.*;

/**
 * 输入：[100,4,200,1,3,2]
 * 输出：4
 *
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
//        int[] num = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        int[] num = Arrays.stream(str).mapToInt(In1 -> Integer.parseInt(In1)).toArray();
//        System.out.println(new Solution().longestConsecutive(num));
        System.out.println(longestConsecutive(num));
    }

    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0;
        for (int num : set) {
            if (set.contains(num-1)) continue;
            int cnt = 0;
            while (set.contains(num)) {
                num++;
                cnt++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
//使用排序
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = 1, l = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            } else if (nums[i] == nums[i-1] + 1) {
                l++;
            } else {
                n = Math.max(n, l);
                l = 1;
            }
        }
        n = Math.max(n, l);
        return n;
    }
}
