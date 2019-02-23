package algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 *
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 */
public class SubarraySum {

    /**
     * HashMap 在Array 题目中一般可以用O(n)的时间复杂度解决两种问题
     1，求两者之和为固定某数

     if (map.contains(sum - curtValue)) {
     index1 = map.get(sum - curtValue);
     index2 = curtIndex;
     break;
     }
     2，求两个index之间的所有数的和为某数

     if (map.contains(curtSum - sum)) {
     index1 = map.get(curtSum - sum);
     index2 = curtIndex;
     break;
     }
     */

    /**
     * 记录每一个位置的sum，存入HashMap中，如果某一个sum已经出现过，那么说明中间的subarray的sum为0. 时间复杂度O(n)，空间复杂度O(n)
     *
     0 -1
     -3 0
     -2 1
     0  2 -> 0,2
     -3 3 -> 1,3
     */

    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here

        int len = nums.length;

        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }

            map.put(sum, i);
        }

        return ans;
    }
}
