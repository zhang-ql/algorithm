package com.zql.huawei;
//https://mp.weixin.qq.com/s/8hiPOB1U9hGph1BHobmavw
import java.util.*;

public class Main11 {

    public static void main(String[] args) {
    // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
    // please finish the function body here.
    // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[][] rad = new int[N][N];

        int maxR = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rad[i][j] = in.nextInt();
                maxR = Math.max(maxR, rad[i][j]);
            }
        }
        int l = Math.max(rad[0][0], rad[N-1][N-1]);
        int h = maxR;
        int res = h;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isR(rad, N, K, mid)) {
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(res);
    }

//    private static int dfs(int arr[][], int n, int k) {
//
//        boolean[][][] f = new boolean[n][n][k+1];
//        Queue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
//        queue.offer(new int[]{0,0,arr[0][0], 0});
//        while (!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            int x = cur[0], y = cur[1], pr = cur[2], st = cur[3];
//            if (x == n - 1 && y == n-1) return pr;
//            for (int[] dir : DIR) {
//                int newX = x + dir[0], newY = y + dir[1];
//                int newS = st + 1;
//                if (newX >= 0 && newX < n && newY >= 0 && newY < n && newS <= k && !visited[newX][newY][newS]) {
//                    f[newX][newY][newS] = true;
//                    queue.offer(new int[] {newX, newY, Math.max(pr, arr[newX][newY]), newS});
//                }
//            }
//
//        }
//        return -1;
//    }

    private static boolean isR(int[][] rad, int N, int K, int maxR) {
        if (rad[0][0] > maxR || rad[N-1][N-1] > maxR) {
            return false;
        }

        boolean[][] f = new boolean[N][N];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0,0});
        f[0][0] = true;

        int[] d_x = {0, 0, 1, -1};
        int[] d_y = {1, -1, 0, 0};
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0], y = cur[1], st1 = cur[2];

            if (st1 > K) continue;

            if (x == N-1 && y == N-1) return true;
            for (int i = 0; i < 4; i++) {
                int nx1 = x + d_x[i];
                int YY = y + d_y[i];
                if (nx1 >= 0 && nx1 < N && YY >= 0 && YY < N && !f[nx1][YY] && rad[nx1][YY] <= maxR) {

                        f[nx1][YY] = true;
                        que.offer(new int[]{nx1, YY, st1+1});

                }
            }
        }
        return false;
    }
}