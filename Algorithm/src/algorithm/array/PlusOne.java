package algorithm.array;

/**
 * 给一个包含非负整数的数组，其中每个值代表该位数的值，对这个数加1。
 *
 Given [1,2,3] which represents 123, return [1,2,4].
 Given [9,9,9] which represents 999, return [1,0,0,0].
 */
public class PlusOne {

    /**
     * 数组的最后一个数是个位数，所以从后面开始读，个位数+1后，如果有进位，存储进位值，没有直接存储。
     处理十位数，如果个位数有进位，十位数+1,在判断十位数有没有进位。
     重复上面的动作直到没有进位。
     */

    // The complexity is O(1)
    // f(n) = 9/10 + 1/10 * O(n-1)
    //  ==>  O(n) =  10 / 9 = 1.1111 = O(1)

    public int[] plusOne(int[] digits) {
        int carries = 1;
        for(int i = digits.length-1; i>=0 && carries > 0; i--){  // fast break when carries equals zero
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        if(carries == 0)
            return digits;

        int[] rst = new int[digits.length+1];
        rst[0] = 1;
        for(int i=1; i< rst.length; i++){
            rst[i] = digits[i-1];
        }
        return rst;
    }
}
