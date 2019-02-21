package jzoffer;

/**
 * 我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。求从小到大的顺序的第1500个丑数。
 举例说明：
 例如6、8 都是丑数，但14 不是，它包含因子7。习惯上我们把1 当做第一个丑数。

 */
public class No49 {


    /**
     *
     如果p是丑数，那么p=2^x * 3^y * 5^z
     那么只要赋予x,y,z不同的值就能得到不同的丑数。
     如果要顺序找出丑数，要知道下面几个特（fei）点（hua）。
     对于任何丑数p：
     （一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
     （二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q

     现在说说算法思想：
     由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1
     的下一个丑数，也就是2*1，
     这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
     这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是
     (3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
     每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。

     在上面的特（fei）点（hua）中，既然有p<q, 那么2*p<2*q，那么
     “我”在前面比你小的数都没被选上，你后面生成新的丑数一定比“我”大吧，那么你乘2
     生成的丑数一定比我乘2的大吧，那么在我选上之后你才有机会选上。
     其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
     数。也就是比较(2*x , 3*y, 5*z) ，x>=y>=z的，
     */

    public int GetUglyNumber_Solution(int N) {
        if (N <= 6)
            return N;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2)
                i2++;
            if (dp[i] == next3)
                i3++;
            if (dp[i] == next5)
                i5++;
        }
        return dp[N - 1];
    }
}
