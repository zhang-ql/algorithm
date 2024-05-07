import java.util.*;
import java.util.stream.Collectors;

/** 哈希表 字符串转数组， 转列表
 * 输入：2 7 11 15
 * 9
 * 输出[0, 1]huo 0 1
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().trim().split(" ");
        int target = in.nextInt();
        in.close();
        int[] num = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        int[] res = twoSum(num, target);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
        List<Integer> list = Arrays.stream(res).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    private static int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(target - num[i])) {
                return new int[]{map.get(target - num[i]), i};
            }
            map.put(num[i], i);
        }
        return new int[]{};
    }
}
