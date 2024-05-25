import java.util.*;

public class Main09 {

    //https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/645290/438-zhao-dao-zi-fu-chuan-zhong-suo-you-z-nx6b/?envType=study-plan-v2&envId=top-100-liked
    //输入: s = "cbaebabacd", p = "abc"
    //输出: [0,6]
    //解释:
    //起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    //起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        List<Integer> res = new Main09().findAnagrams(s, p);
        System.out.println(res);
        in.close();
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : p.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        int left = 0, right = 0, valid = 0;
        //初始化窗口 记录最小覆盖子串的起始索引及长度
        //int len = Integer.MAX_VALUE, start = 0;
        while (right < s.length()) {
            //右移窗口
            char c = s.charAt(right);
            right++;
            //进行窗口更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) valid++;
            }
            //判断窗口是否需要收缩
            while (right - left >= p.length()) {
                if (valid == need.size())
                    res.add(left);
                //左移窗口
                char d = s.charAt(left);
                left++;
                //进行窗口更xin
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) return res;
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCnt, sCnt)) {
            res.add(0);
        }
        for (int i = m; i < n; i++) {
            sCnt[s.charAt(i - m) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCnt, pCnt)) {
                res.add(i-m+1);
            }
        }
        return res;
    }
    
    public boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
