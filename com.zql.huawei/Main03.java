package com.zql.huawei;
//https://mp.weixin.qq.com/s/iBCPI7KB7A2vLio-IMsEwQ
//足球队员射门能力排序

import java.util.*;
/**
 *
 * 球队有n个足球队员参与m次射门训练，每次射门进球用1表示，射失则用0表示，依据如下规则对该n个队员的射门能力做排序
 * 1、进球总数更多的队员射门能力更强 2、若进球总数—样多，则比较最多—次连续进球的个数，最多的队员能力更强 3、若最多一次连续进球的个数一样多，则比较第一次射失的先后顺序，
 * 其中后射失的队员更强，若第一次射失顺序相同，则按继续比较第二次射失的顺序，后丢球的队员能术更强，依次类推 4、若前3个规则排序后还能力相等，则队员编号更小的能力更强
 *
 *输入
 *
 * 第1行，足球队员数n，射门训练次数m。(队员编号从1开始，依次递增) 第2行，第1~n个队员从第1到m次训练的进球情况，每个队员进球情况为连续的1和0的组合，不同队员用空格分隔n和m均为正整数，0<n<=10 ^ 3，0<m<=10^3
 *
 * 输出
 *
 * 射门能力从强到弱的队员编号,用空格分隔
 *
 * 样例1
 *
 * 输入:
 *
 * 4 5
 * 11100 00111 10111 01111
 * 输出:
 *
 * 4 3 1 2
 *解释:4个队员，射门训练5次，队员3和4进球数均为4个，比队员1和2的3个更多,队员3连续进球数最多一次为3个,
 * 而队员4最大为4，因此队员4射门能力强于队员3,另外队员2比队员1先丢球，因此队员1射门能力强于队员2，排序为4312
 *
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        int[] goals = new int[n];
        int[] seq = new int[n];
        List<List<Integer>> fs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fs.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String s = in.next();
            //g得分，最大连续得分，当前得分
            int g = 0, mx_s = 0, cur_s = 0;
            for (int j = 0; j < m; j++) {
                g += (s.charAt(j) == '1' ? 1 : 0);
                if (s.charAt(j) == '1') ++cur_s;
                else {
                    fs.get(i).add(j);
                    mx_s = Math.max(mx_s, cur_s);
                    cur_s = 0;
                }
            }
            goals[i] = g;
            seq[i] = Math.max(mx_s, cur_s);
        }
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> { //(a, b)数组索引。或元素的位置
           //进球数
           if(goals[a] > goals[b]) return -1;
           if(goals[a] < goals[b]) return 1;
           //最大连续进球数
            if (seq[a] > seq[b]) return -1;
            if (seq[a] < seq[b]) return 1;
            //射失顺序
            List<Integer> fa = fs.get(a), fb = fs.get(b);
            for (int j = 0; j < fa.size(); j++) {
                if (fa.get(j) > fb.get(j)) return -1;
                if (fa.get(j) < fb.get(j)) return 1;
            }
           return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(idx[i] + 1).append((i != n-1) ? " " : "");
        }
        System.out.println(sb.toString());
    }
}
