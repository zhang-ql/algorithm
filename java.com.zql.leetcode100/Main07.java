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

    //双指针 前缀、后缀最大值
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

    //单调栈
    public int trap1(int[] height) {
        int ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!dq.isEmpty() && height[i] > height[dq.peek()]) {
                int bottomH = height[dq.pop()];
                if (dq.isEmpty()) break;
                int left = dq.peek();
                int dh = Math.min(height[left], height[i]) - bottomH;//高度
                ans += dh * (i - left - 1);
            }
            dq.push(i);
        }
        return ans;
    }
}
