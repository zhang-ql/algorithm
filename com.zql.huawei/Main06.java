package com.zql.huawei;

import java.util.*;

public class Main06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] MN = scanner.nextLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> lvl1s = new HashMap<>();
        Map<String, Integer> lvl2s = new HashMap<>();

        Set<String> fathers = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            String node = input[0];
            String fa = input[1];
            String lvl = input[2];
            String cnt = input[3];

            if ("*".equals(fa)) {
                fathers.add(node);
            } else {
                // 如果fa不存在，则创建一个HashSet并添加到graph
                graph.computeIfAbsent(fa, k -> new HashSet<>()).add(node);
            }

            if ("0".equals(lvl)) {
                lvl1s.put(node, Integer.parseInt(cnt));
            } else {
                lvl2s.put(node, Integer.parseInt(cnt));
            }
        }

        int cnt = 0;
        for (String f : fathers) {
            int c1 = dfs(f, lvl1s, graph);
            int c2 = dfs(f, lvl2s, graph);
            if (5 * c1 + 2 * c2 > M) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static int dfs(String node, Map<String, Integer> lvl, Map<String, Set<String>> graph) {
        int lvl1 = lvl.getOrDefault(node, 0);
        for (String child : graph.getOrDefault(node, Collections.emptySet())) {
            int c1 = dfs(child, lvl, graph);
            lvl1 += c1;
        }
        return lvl1;
    }

}