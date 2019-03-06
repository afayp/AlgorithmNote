package jzoffer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 字符串的排列
 *
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class No38 {

    /**
     * 把一个字符串看成由两部分组成：第一部分为它的第一个字符，第二部分是后面的所有字符。
     * 我们求整个字符串的排列，可以看成两步：
     * 首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。
     * 这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。
     * 这其实是很典型的递归思路。
     */


    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }

    public void PermutationHelper(char[] cs, int index, List<String> list) {
        if (index == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int i = index; i < cs.length; i++) {
                swap(cs, index, i);
                PermutationHelper(cs, index+1, list);
                swap(cs, index, i); // 还原回来
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
