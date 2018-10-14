package algorithm.sort;

/**
 * 选择排序
 */
public class SelectionSort {


    // 常规
    // 扫描剩余n-i个元素中的最小值，放到第i个位置上，第i个位置的左边都是有序的
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    // 改进 在每一轮中, 可以同时找到当前未处理元素的最大值和最小值
    public static void sort2(Comparable[] arr) {

        int left = 0, right = arr.length - 1;
        while(left < right){
            int minIndex = left;
            int maxIndex = right;

            // 在每一轮查找时, 要保证arr[minIndex] <= arr[maxIndex]
            if(arr[minIndex].compareTo(arr[maxIndex]) > 0)
                swap(arr, minIndex, maxIndex);

            for(int i = left + 1 ; i < right; i ++)
                if(arr[i].compareTo(arr[minIndex]) < 0)
                    minIndex = i;
                else if(arr[i].compareTo(arr[maxIndex]) > 0)
                    maxIndex = i;

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left ++;
            right --;
        }

    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("sortbasic.SelectionSort",arr);
    }
}
