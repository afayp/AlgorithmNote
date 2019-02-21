package jzoffer;

/**
 * 数值的整数次方
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 */
public class No16 {

    /**
     *1.当底数为0且指数<0时
     *会出现对0求倒数的情况，需进行错误处理，设置一个全局变量；
     *2.判断底数是否等于0
     *由于base为double型，不能直接用==判断
     *3.优化求幂函数
     *当n为偶数，a^n =（a^n/2）*（a^n/2）
     *当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
     *时间复杂度O(logn)
     */

    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;
        return isNegative ? 1 / pow : pow;
    }

}
