package algorithm.sort;

/**
 * 快速排序
 * 1．先从数列中取出一个数作为基准数。
 * <p>
 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * <p>
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 */
public class QuickSort {

    public static void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r) return;

        //取第一个数为参考值
        Comparable data = arr[l];
        int i = l;
        int j = r;

        //当 i 和 j 还没有碰到一起时候，一直重复移动 j 和 i 等操作
        while (i != j) {

            while (arr[j].compareTo(data) >= 0 && i < j) {
                j--;
            }

            while (arr[i].compareTo(data) <= 0 && i < j) {
                i++;
            }

            if (i <j) {
                Comparable t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        //当退出上面的循环，说明 i 和 j 的位置交汇了，更换参考值与 i 位置的值。
        arr[l] = arr[i];
        arr[i] = data;

        //左边的数组通过递归继续调用，这时候因为参考值在 i 的位置，所以左边是从start 到 i -1
        quickSort(arr, l, i - 1);
        //右边的数组通过递归继续调用，这时候因为参考值在 i 的位置，所以右边是从 i -1 到 end
        quickSort(arr, i + 1, r);

    }

    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                SortTestHelper.swap(arr, j, i);
            }
        }

        SortTestHelper.swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        if (l >= r)
            return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 测试 QuickSort
    public static void main(String[] args) {


        Integer[] arr1 = {3, 1, 2, 5, 4};
        quickSort(arr1,0,4);
        SortTestHelper.printArray(arr1);

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
//        int N = 1000000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SortTestHelper.testSort("sortbasic.QuickSort", arr);

        return;
    }


}
