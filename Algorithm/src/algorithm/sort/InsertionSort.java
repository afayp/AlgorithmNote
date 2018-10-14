package algorithm.sort;

/**
 * 插入排序
 */
public class InsertionSort {


    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {

//            for (int j = i; j >0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
//                swap(arr,j,j-1);
//            }

            // 改进
            Comparable e = arr[i];
            int j = i;
            for (; j>0 && e.compareTo(arr[j-1]) < 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }

    }

    public static void swap(Object[] arr , int i , int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sortbasic.InsertionSort", arr);

        return;
    }
}
