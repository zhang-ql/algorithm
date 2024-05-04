package com.zql.huawei;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//对应Main03
class Player {
    int id;
    int goals;
    int maxConsecutiveGoals;
    List<Integer> misses; // 记录射失的顺序

    public Player(int id, int goals, int maxConsecutiveGoals, List<Integer> misses) {
        this.id = id;
        this.goals = goals;
        this.maxConsecutiveGoals = maxConsecutiveGoals;
        this.misses = misses;
    }
}

public class FootballTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int goals = 0, maxConsecutiveGoals = 0, curConsecutiveGoals = 0;
            List<Integer> misses = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '1') {
                    goals++;
                    curConsecutiveGoals++;
                } else {
                    misses.add(j);
                    curConsecutiveGoals = 0;
                }
                maxConsecutiveGoals = Math.max(maxConsecutiveGoals, curConsecutiveGoals);
            }
            players.add(new Player(i, goals, maxConsecutiveGoals, misses));
        }

        // 根据给定规则对球员进行排序
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player a, Player b) {
                // 规则1：进球总数更多的队员射门能力更强
                if (a.goals != b.goals) {
                    return Integer.compare(b.goals, a.goals);
                }
                // 规则2：最多一次连续进球的个数，最多的队员能力更强
                if (a.maxConsecutiveGoals != b.maxConsecutiveGoals) {
                    return Integer.compare(b.maxConsecutiveGoals, a.maxConsecutiveGoals);
                }
                // 规则3：比较射失的先后顺序
                int minSize = Math.min(a.misses.size(), b.misses.size());
                for (int i = 0; i < minSize; i++) {
                    if (a.misses.get(i) != b.misses.get(i)) {
                        return Integer.compare(b.misses.get(i), a.misses.get(i));
                    }
                }
                // 如果射失顺序相同，则规则4：队员编号更小的能力更强
                return Integer.compare(a.id, b.id);
            }
        });

        // 打印排序后的队员编号
        for (Player player : players) {
            System.out.print(player.id + 1); // 编号从1开始
            if (player != players.get(players.size() - 1)) {
                System.out.print(" ");
            }
        }
    }
}