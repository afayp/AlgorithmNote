package jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 举例说明

 例如输入数组｛1 、2 、4、7 、11 、15 ｝和数字15. 由于4+ 11 = 15 ，因此输出4 和11 。
 */
public class No57 {

    /**
     * 我们先在数组中选择两个数字，如果它们的和等于输入的s，我们就找到了要找的两个数字。
     * 如果和小于s 呢？
     * 我们希望两个数字的和再大一点。由于数组已经排好序了，我们可以考虑选择较小的数字后面的数字。
     * 因为排在后面的数字要大一些，那么两个数字的和也要大一些， 就有可能等于输入的数字s 了。
     * 同样， 当两个数字的和大于输入的数字的时候，我们可以选择较大数字前面的数字，因为排在数组前面的数字要小一些。
     *
     * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。

     如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     如果 sum > target，移动较大的元素，使 sum 变小一些；
     如果 sum < target，移动较小的元素，使 sum 变大一些。
     */

    public static List<Integer> findNumbersWithSum(int[] data, int sum) {
        List<Integer> result = new ArrayList<>(2);

        if (data == null || data.length < 2) {
            return result;
        }

        int ahead = data.length - 1;
        int behind = 0;
        long curSum; // 统计和，取long是防止结果溢出

        while (behind < ahead) {
            curSum = data[behind] + data[ahead];

            if (curSum == sum) {
                result.add(data[behind]);
                result.add(data[ahead]);
                break;
            } else if (curSum < sum) {
                behind++;
            } else {
                ahead--;
            }
        }

        return result;
    }

}
