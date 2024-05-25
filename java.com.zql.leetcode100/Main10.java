import java.util.*;
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//子数组是数组中元素的连续非空序列。
//https://leetcode.cn/problems/subarray-sum-equals-k/solutions/2781031/qian-zhui-he-ha-xi-biao-cong-liang-ci-bi-4mwr/?envType=study-plan-v2&envId=top-100-liked
//输入：nums = [1,1,1], k = 2
//输出：2
public class Main10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(",");
        int[] array = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        int res = new Main10().subarraySum(array, 2);
        System.out.println(res);
    }

    //统计s[j]前面有多少个前缀和等于s[j]-k,即为元素和等于k的子数组个数
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + nums[i];
        }
        Map<Integer, Integer> cnt = new HashMap<>(n+1);
        int ans = 0;
        for(int sj : s) {
            ans += cnt.getOrDefault(sj - k, 0);
            cnt.merge(sj, 1, Integer::sum);
        }
        return ans;
    }
}
