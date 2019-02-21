package jzoffer;


/**
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 */
public class No50 {

    /**
     * 最直观的解法是使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，因此可以使用整型数组代替 HashMap。
     */

    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        // 依据原字符串的顺序进行遍历并在map中进行查找的，遇到第一个数值对应为1的字符后就直接输出了。
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }

}
