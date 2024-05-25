import java.util.*;

public class Main08 {
    //https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/1959532/biao-ti-xia-biao-zong-suan-cuo-qing-kan-k81nh/
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
    //s = "abcabcbb"
    //输出: 3
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(" ");
        String str = String.join("", strArr);
        System.out.println(str);
        int res = new Main08().lengthOfLongestSubstring(str);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0, left = 0;
        Set<Character> window =new HashSet<Character>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (window.contains(c)) {
                window.remove(s.charAt(left++));
            }
            window.add(c);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
