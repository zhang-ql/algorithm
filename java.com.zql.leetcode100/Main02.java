import java.util.*;
import java.util.stream.Collectors;

/**
 * 哈希表
 * 输入：strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出：[["bat"],["nat", "tan"],["ate", "eat", "tea"]]
 *
 */

public class Main02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strs = str.split(",\\s");//逗号后面的任意空白字符
            List<List<String>> list = new Main02().groupAnagrams(strs);
            System.out.println(list);
//            String result = list.stream().map(list1 -> list1.stream().collect(Collectors.joining(","))).toString();
//            String result = list.stream().flatMap()
//                            .collect(Collectors.joining(","));
            String result = list.stream().map(innerList -> innerList.stream().collect(Collectors.joining(",")))//使用内部的map操作将每个子列表(innerList)转换为由逗号分隔的字符串
                            .collect(Collectors.joining("; "));//使用外部的collect操作将所有子列表字符串由分号和空格分隔。
            String result1 = new Main02().convertNestedListToString(list);
            System.out.println(result1);
        }
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String string = new String(charArray);
            List<String> list = map.getOrDefault(string, new ArrayList<>());
            list.add(str);
            map.put(string, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    private String convertNestedListToString(List<List<String>> nestedList) {
        StringBuilder result = new StringBuilder();
        for (List<String> innerList : nestedList) {
            for (int i = 0; i < innerList.size(); i++) {
                result.append(innerList.get(i));
                if (i < innerList.size() - 1) {
                    result.append(",");
                }
            }
            if (nestedList.indexOf(innerList) < nestedList.size() - 1) {
                result.append("; ");
            }
        }
        return result.toString();
    }


}
