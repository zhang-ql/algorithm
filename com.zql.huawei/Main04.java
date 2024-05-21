package com.zql.huawei;

import java.util.*;

/**
 * 从一副扑克牌中随机抽取n张牌组成一个序列，规定连续3张相同牌号的卡牌可以消除，
 * 剩余卡牌按照当前顺序重新合并成新的序列后继续消除，重复以上步骤直到无法消除，最后请输出结束后剩余的卡牌序列。
 * @author zhangqianlong
 * https://mp.weixin.qq.com/s/i8CXFWWkAIlStggTVfEq1Q
 */

public class Main04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        in.nextLine();
//        int n = Integer.parseInt(in.next());
//        in.nextLine();
//        String[] strArr = in.nextLine().split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
//            String str = strArr[i];
            String str = in.next();
            stack.push(str);
            while (stack.size() >= 3 && stack.get(stack.size() - 1).equals(stack.get(stack.size() - 2)) && stack.get(stack.size() - 1).equals(stack.get(stack.size() - 3))) {
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }
        in.close();
        if (stack.isEmpty()) {
            stack.push("0");
        }
        String[] strings = stack.stream().map(String::valueOf).toArray(String[]::new);
        System.out.print(String.join(" ", strings));
    }
}
