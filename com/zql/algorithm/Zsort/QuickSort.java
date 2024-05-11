package com.zql.algorithm.Zsort;

public class QuickSort {
    // 快速排序方法
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找到分区的索引
            int partitionIndex = partition(arr, low, high);

            // 递归排序左半部分
            quickSort(arr, low, partitionIndex - 1);
            // 递归排序右半部分
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // 分区函数    i为实际值
    private static int partition(int[] arr, int low, int high) {
        // 选择最右侧的元素作为基准值
        int pivot = arr[high];
        int i = (low - 1); // 指向小于基准的最后一个元素

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准
            if (arr[j] <= pivot) {
                i++;

                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 将基准值换到中间
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 返回基准值的新索引
    }

    //分区函数
    private static int partition1(int[] arr, int low, int high) {
        int pivot = arr[high];
        int left = low, right = high - 1;
        while (left <= right) {
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //将基准换到中间
        int temp = arr[left];
        arr[left] = arr[high];
        arr[high] = temp;
        return left;
    }

    // 主函数用来测试排序算法
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 7, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
