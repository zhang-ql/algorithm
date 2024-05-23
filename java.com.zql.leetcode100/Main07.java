import java.util.*;
public class Main07 {
    //接雨水 https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-100-liked
    //0,1,0,2,1,0,1,3,2,1,2,1
    //6
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(",");
        int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        int ans = new Main07().trap(arr);
        System.out.println(ans);
    }

    //双指针
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0, left = 0, right = n - 1;
        int pre_max = 0, suf_max = 0;
        while (left < right) {
            pre_max = Math.max(pre_max, height[left]);
            suf_max = Math.max(suf_max, height[right]);
            ans += pre_max < suf_max ? pre_max - height[left++] : suf_max - height[right--];
        }
        return ans;
    }
}
