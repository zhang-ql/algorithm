package com.zql.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入：
 * 6
 * 4 5 7 1 1 2
 * 3
 * 输出：
 * 1
 * 给定一个整数数组nums，同时给定一个整数interval。 指定数组nums中的某个元素作为起点，
 * 然后以interval为间隔递增，如果递增的数（包含起点）等于nums中的元素，
 * 则将数组nums中对应的元素消除，返回消除元素最多的起点元素。如果消除的元素同样多，则返回最小的起点元素。
 *
 *假设最后的序列是: a0,a1,a2,.....,an，其中，ai必然满足 a0 + k*interval，其中k是任意自然数。
 * 那么这些所有的元素都满足  ai%interval = a0。
 *
 */

public class Main08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int interval = Integer.parseInt(in.next());
        Map<Integer, Integer> remain = new HashMap<>();
        for (int num : nums) {
            int s = num % interval;
            remain.merge(s, 1, Integer::sum);
        }
        int max = 0;
        Integer res = null;

        for (int num : nums) {
            int s = num % interval;
            if (remain.get(s) > max || (remain.get(s) == max) && (res == null || num < res)) {
                max = remain.get(s);
                res = num;
            }
        }
        System.out.println(res);
        in.close();
    }
}
