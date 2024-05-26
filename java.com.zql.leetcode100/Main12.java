import java.util.*;

public class Main12 {
    //最小覆盖字串
    //https://leetcode.cn/problems/minimum-window-substring/submissions/534875948/?envType=study-plan-v2&envId=top-100-liked
    //输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    //解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
    //

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        System.out.println(new Main12().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        //把need和窗口中的元素进行比较
        Map<Character, Integer> need = new HashMap<>(),window = new HashMap<>();
        for (char c : t.toCharArray()) need.merge(c, 1, Integer::sum);
        int left = 0, right = 0, valid = 0;
        int start = 0, minLen = Integer.MAX_VALUE;//找最小窗口开始的位置，以及窗口的长度
        while (right < s.length()) {
            //进入更新窗口
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {//need中有这个元素放入window,不一定把所有的元素都加进入，使用left和right来记录窗口的开始和结束
                window.merge(c, 1, Integer::sum);
                if (window.get(c).equals(need.get(c))) valid++;
            }
            //判断窗口是否收缩，出窗口
            while (valid == need.size()) {
                if (right - left < minLen) {//更新最小窗口
                    start = left;
                    minLen = right - left;
                }
                //d 是将移除窗口的元素
                char d = s.charAt(left);
                left++;
                if (window.containsKey(d)) {//当valid和need.size()相等时，need和window中的元素都相等
                    if (window.get(d).equals(need.get(d))) valid--;//如果包含，left++把valid减1
                    window.put(d, window.get(d) - 1);//如果包含，left++把d元素移除
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}
