package jzoffer;

public class No10 {

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(JumpFloor(5));
    }

    // 写一个函数，输入n，求斐波那契数列的第n项
    public static long fibonacci(int n) {

        if (n <= 1) {
            return n;
        }
        long f1 = 0;
        long f2 = 1;
        long fN = 0;
        for (int i = 2; i <= n; i++) {
            fN = f1 + f2;
            f1 = f2;
            f2 = fN;
        }
        return fN;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级台阶总共有多少种跳法
     * 
     * 解： 对于本题,前提只有 一次 1阶或者2阶的跳法。
     * 
     * a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
     * 
     * b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
     * 
     * c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 
     * 
     * d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
     * 
     * 
     * 
     * e.可以发现最终得出的是一个斐波那契数列：
     * 
     * | 1, (n=1)
     * 
     * f(n) = | 2, (n=2)
     * 
     * | f(n-1)+f(n-2) ,(n>2,n为整数)
     * 
     * 
     */
    public static int JumpFloor(int n) {

        if (n <= 0) {
            return -1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            // 递归
            // return JumpFloor(n-1) + JumpFloor(n-2);

            // 迭代
            int first = 1, second = 2, result = 0;
            for (int i = 3; i <= n; i++) {
                result = first + second;
                first = second;
                second = result;
            }
            return result;
        }

    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 
     * 解：
     * n = 1时，只有1种跳法，f(1) = 1
     * n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)
     * n = 3时，会有三种跳得方式，1阶、2阶、3阶，
     * 那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
     * 因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
     * n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
     * f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(n) = f(0) + f(1) + f(2) + f(3) ... + f(n-2) + f(n-1)
     * f(n-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) so =>
     * f(n) = f(n-1) + f(n-1) = 2*f(n-1)
     */
    public static int JumpFloorII(int n) {

        if (n <= 0) {
            return -1;
        } else if (n == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(n - 1);
        }

    }

}