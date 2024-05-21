package com.zql.huawei;
import java.util.*;

// https://mp.weixin.qq.com/s/pY0EHj0eVLgIfkDiJb0RSQ
//老鼠串门
/**
输入：
1 1 2 3 4 4 5
输出：
1 4 5 4 3 2 1

 输入：
 1 2 3 2 3 4 5
 输出：
 3 2 5 4 3 2 1
 */


public class Main07 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        List<Integer> seq = new ArrayList<>();
        for (String s : input) {
            seq.add(Integer.parseInt(s));
        }
        System.out.println(seq);

        Stack<Integer> sk = new Stack<>();
        Set<Integer> occ =  new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (Integer num : seq) {
            if (occ.contains(num)) {
                while (!sk.isEmpty() && sk.peek() != num) {
                    int tp = sk.pop();
                    occ.remove(tp);
                    res.add(tp);
                }
                if (!sk.isEmpty() && sk.peek() == num) {
                    res.add(num);
                }
            } else {
                occ.add(num);
                sk.push(num);
            }
        }
        while (!sk.isEmpty()) {
            res.add(sk.pop());
        }

        for (int i = 0; i < res.size(); i++) {
            if (i != 0) {
                System.out.print(" " + res.get(i));
            } else {
                System.out.print(res.get(i));
            }
        }
        System.out.println();
        System.out.println(res.stream().map(String::valueOf).reduce((a, b) -> a + " " + b).orElse(""));
        System.out.println(res.stream().map(String::valueOf).reduce((a, b) -> a + " " + b).orElse(""));
    }
}
