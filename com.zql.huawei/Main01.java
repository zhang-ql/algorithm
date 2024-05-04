package com.zql.huawei;
//https://mp.weixin.qq.com/s/iBCPI7KB7A2vLio-IMsEwQ
import java.util.*;
import java.util.stream.Collectors;

public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
//        for (String s : strArr) {
//            list.add(Integer.parseInt(s))
//        }
        list = Arrays.stream(strArr).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int target = in.nextInt();
        Collections.sort(list);
        String ans = "S";
        int l = 0, r = list.size() - 1;
        //记录次数
        int d = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            d++;
            if (list.get(m) == target) {
                ans += "Y";
                break;
            }
            //右边减一
            if (list.get(m) > target) {
                if (Math.pow(2, d) > list.size()) break;
                ans += "L";
                r = m - 1;
            } else {
                if (Math.pow(2, d) > list.size()) break;
                ans += "R";
                l = m + 1;
            }
        }
        if (ans.charAt(ans.length() - 1) != 'Y') {
            ans += "N";
        }
        System.out.println(ans);
    }
}
