package jzoffer;

/**
 * https://www.nowcoder.com/ta/coding-interviews
 */
public class No04 {

    /**
     * 在一个二维数组中，每一行都按照从左到右递增
     * 的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组
     * 和一个整数，判断数组中是否函数该整数。
     */
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        System.out.println(search(arr, 7));
    }


    public static boolean search(int[][] array, int target) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col])
                return true;
            else if (target > array[row][col])
                row++;
            else
                col--;
        }
        return false;
    }
}
