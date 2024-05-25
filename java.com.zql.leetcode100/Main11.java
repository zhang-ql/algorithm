import java.util.*;
//https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked
//滑动窗口最大值
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
public class Main11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] arr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        int[] ints = new Main11().maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(ints));
        String join = String.join(" ", Arrays.stream(ints).mapToObj(String::valueOf).toArray(String[]::new));
        System.out.println(join);
        in.close();
        boolean first = true;
        for (int i = 0; i < ints.length; i++) {
            if (!first) {
                System.out.print(" ");
            }
            System.out.print(ints[i]);
            first = false;
        }
    }

    //使用大顶堆
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            ////返回-1：表示a应该排在b前面，这里用于实现降序（如果a的值大于b）。
            //返回1：表示b应该排在a前面，这里用于实现降序（如果a的值小于b）。
            //返回0：表示a和b的顺序不变，通常用于处理相等的情况。
            //(1, 2)进行比较，返回1， 2排在前面
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0] ? p2[0]-p1[0] : p2[1] - p1[1];
            }
        });
        for(int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});//加入到最后，自动排序
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            //不能超过窗口大小
            while (pq.peek()[1] <= i - k) {
                pq.poll();//弹出第一个元素
            }
            ans[i-k+1] = pq.peek()[0];
        }
        return ans;
    }

    //单调栈
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); // 双端队列
        for (int i = 0; i < n; i++) {
            // 1. 入
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.addLast(i); // 入队
            // 2. 出
            if (i - q.getFirst() >= k) { // 队首已经离开窗口了
                q.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[i - k + 1] = nums[q.getFirst()];
            }
        }
        return ans;
    }
}
