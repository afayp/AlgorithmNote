package algorithm.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i-1].compareTo(arr[i]) > 0) {
                    SortTestHelper.swap(arr,i-1,i);
                    swapped = true;
                }
            }
            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            n--;
        }while (swapped);
    }

    public static void sort2(Comparable[] arr){

        int n = arr.length;
        int newn; // 使用newn进行优化

        do{
            newn = 0;
            for( int i = 1 ; i < n ; i ++ )
                if( arr[i-1].compareTo(arr[i]) > 0 ){
                    SortTestHelper.swap( arr , i-1 , i );

                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            n = newn;
        }while(newn > 0);
    }

    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sortbasic.BubbleSort", arr);

        return;
    }
}
