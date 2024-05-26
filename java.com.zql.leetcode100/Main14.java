import java.util.*;

public class Main14 {
    //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
    // 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    public static void main(String[] args) {
        Main14 main14 = new Main14();
        int[][] a = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] b = main14.merge(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i][0] + " " + b[i][1]);
            if (i != b.length - 1) System.out.println();
        }
        System.out.println();
        boolean first = true;
        for (int[] arr : b) {
            if(!first) System.out.print(" ");
            System.out.print(arr[0] + " " + arr[1]);
            first = false;
        }
    }

    public int[][] merge(int[][] a) {
        if (a.length == 0) return new int[0][2];
//        Arrays.sort(a, ((o1, o2) -> o1[0] - o2[0]));
        Arrays.sort(a, (o1, o2)->{
//            return o1[0] - o2[0];
            if (o1[0] < o2[0]) return -1;
            if ((o1[0]> o2[0])) return 1;
            return 0;

        });
//        Arrays.sort(a, new Comparator<int[]>() {
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int l = a[i][0], r = a[i][1];
            if (list.size() == 0 || list.get(list.size()-1)[1] < l) {
                list.add(new int[]{l, r});
            } else {
                list.get(list.size() - 1)[1] = Math.max(r, list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
