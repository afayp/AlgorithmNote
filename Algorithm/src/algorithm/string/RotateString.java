package algorithm.string;

/**
 Given a string and an offset, rotate string by offset. (rotate from left to right)
 Example
 Given "abcdefg".
 offset=0 => "abcdefg" offset=1 => "gabcdef" offset=2 => "fgabcde" offset=3 => "efgabcd"
 Challenge
 Rotate in-place with O(1) extra memory.

 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 */
public class RotateString {

    /**
     * @param str:    an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here

        if (str == null || str.length == 0) {
            return;
        }
        offset %= str.length; //offset先对str的长度求余，该余数即为需要转动的次数
        swap(str, 0, str.length - 1);
        swap(str, 0, offset - 1);
        swap(str, offset, str.length - 1);
    }

    private void swap(char[] str, int i, int j) {
        while (i < j) {
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
            i++;
            j--;
        }
    }
}
