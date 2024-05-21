package xiecheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MagicBallsSolver {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<Integer, Integer> ballsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            ballsMap.put(a, ballsMap.getOrDefault(a, 0) + b);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for (int key : ballsMap.keySet()) {
            minHeap.offer(key);
        }
        solveAndPrint(ballsMap, minHeap);
    }

    private static void solveAndPrint(Map<Integer, Integer> ballsMap, PriorityQueue<Integer> minHeap) {
        while (!minHeap.isEmpty()) {
            int current = minHeap.poll();
            int count = ballsMap.get(current);

            int pairs = count / 2;
            if (pairs > 0) {
                int nextValue = current + 2;
                ballsMap.put(nextValue, ballsMap.getOrDefault(nextValue, 0) + pairs);
                minHeap.offer(nextValue);
            }
            ballsMap.put(current, count % 2);
        }

        List<Integer> finalBalls = new ArrayList<>();
        for (int key : ballsMap.keySet()) {
            int count = ballsMap.get(key);
//            for (int i = 0; i < count; i++) {
//                finalBalls.add(key);
//            }
            if (count == 1) {
                finalBalls.add(key);
            }
        }

        Collections.sort(finalBalls);
        System.out.println(finalBalls.size());
        System.out.println(String.join(" ", finalBalls.stream().map(String::valueOf).toArray(String[]::new)));
    }
}