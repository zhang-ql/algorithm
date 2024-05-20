package xiecheng;

import java.util.*;

public class MagicBalls {
    /**
     *https://mp.weixin.qq.com/s/AE9kx4_c0-r83M1sFaEgpA
     * 第三题
     * 2
     * 3 4
     * 4 3
     * 输出
     * 3
     * 4 6 7
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][] magicBalls = new int[num][2];
        for (int i = 0; i < num; i++) {
            magicBalls[i][0] = in.nextInt();
            magicBalls[i][1] = in.nextInt();
        }

        // 示例数据，n种魔法球，每种的魔力值ai和数量bi
//        int[][] magicBalls = {{1, 2}, {2, 3}, {3, 1}};
        // 使用优先队列（小根堆）存储魔力值及其数量
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // 使用哈希映射记录所有魔力值及其对应的球数量
        Map<Integer, Integer> ballCounts = new HashMap<>();
        // 初始化队列和哈希映射
        for (int[] ball : magicBalls) {
            queue.offer(ball);
            ballCounts.put(ball[0], ballCounts.getOrDefault(ball[0], 0) + ball[1]);
        }
        // 记录最终状态的列表，因为魔力值可能增加，不能直接复用magicBalls
        List<int[]> finalBalls = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 取出魔力值最小的球
            int value = current[0];
            int count = current[1];
            
            if (count == 1) { // 如果只剩一个，无法合并，直接计入总数，并记录
                finalBalls.add(new int[]{value});
            } else { // 否则，可以合并
                int newCount = count / 2;
                if (count % 2 != 0) { // 奇数个时，会剩下一个原魔力值的球
                    finalBalls.add(new int[]{value});
                }
                // 更新或添加合并后的新魔力值到哈希映射和队列
                ballCounts.put(value + 2, ballCounts.getOrDefault(value + 2, 0) + newCount);
                queue.offer(new int[]{value + 2, newCount});
            }
        }
        System.out.println(finalBalls.size());
        boolean first = true;
        for (int[] finalBall : finalBalls) {
            if(!first) {
                System.out.print(" ");
            }
            first = false;
            System.out.print(finalBall[0]);
        }
    }
}
