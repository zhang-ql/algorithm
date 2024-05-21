package com.zql.huawei;

import java.util.*;
//https://mp.weixin.qq.com/s/acRCz0zHLEw2C4bKqlZRrA
//3 1
//1 2
//2 3
//1 1
//3
public class Main09 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            intervals.add(new int[]{a, b});
        }
        // 按照左端点排序
        //Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]); intervals不是数组
        intervals.sort((o1, o2) -> o1[0] - o2[0]);
        //小顶堆 用于高效维护最小的endDay
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int currDay = 1;
        int i = 0;
        while (i < n || !pq.isEmpty()) {
            //将开始时间放入
            while (i < n && intervals.get(i)[0] == currDay) {
                pq.add(intervals.get(i)[1]);
                i++;
            }
            //将已经结束的 弹出 即堆顶的结束时间小于currDay的
            while (!pq.isEmpty() && pq.peek() < currDay) {
                pq.remove();
            }

            //从堆中连续取出k个出来解决掉
            for (int j = 0; j < k; j++) {
                if (!pq.isEmpty()) {
                    res++;
                    pq.remove();
                }
            }
            //当前的天往前走一天，开始看下下一天能不能参加会议
            currDay++;
        }
        System.out.print(res);
    }
}
