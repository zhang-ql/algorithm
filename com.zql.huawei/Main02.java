package com.zql.huawei;

import java.util.*;
import java.util.stream.Collectors;

//https://mp.weixin.qq.com/s/iBCPI7KB7A2vLio-IMsEwQ
//使用二叉树
//https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
public class Main02 {
    private static class TreeNodeMain02 {
        int val;
        TreeNodeMain02 left;
        TreeNodeMain02 right;

        TreeNodeMain02(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(" ");
        //List<Integer> list = Arrays.stream(strArr).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        int target = in.nextInt();
        in.close();
//        String ans = "S";
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        TreeNodeMain02 root = sortedArrayToBST(arr, 0, arr.length - 1);
        String path = findPath(root, target);
        System.out.println(path);
    }

    //二叉搜索树
//    private static TreeNodeMain02 sortedArrayToBST(int[] nums, int start, int end) {
//        if (start < end) return null;
//        int mid = start + (end - start) / 2;;
//        TreeNodeMain02 node = new TreeNodeMain02(nums[mid]);
//        node.left = sortedArrayToBST(nums, start, mid - 1);
//        node.right = sortedArrayToBST(nums, mid+1, end);
//        return node;
//    }
    private static TreeNodeMain02 sortedArrayToBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNodeMain02(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNodeMain02 root = new TreeNodeMain02(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid);
        root.right = sortedArrayToBST(nums, mid+1, right);
        return root;
    }

    private static String findPath(TreeNodeMain02 root, int target) {
        String ans = "S";
        TreeNodeMain02 cur = root;
        while (cur != null) {
            if(target < cur.val) {
                ans += "L";
                cur = cur.left;
            } else if (target > cur.val) {
                ans += "R";
                cur = cur.right;
            } else {
                ans += "Y";
                break;
            }
        }
        if (cur == null) {
            ans += "N";
        }
        return ans;
    }

}
