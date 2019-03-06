package algorithm.array;

import java.util.Arrays;

/**
 * 现有n个灯泡，默认都是关闭的。第一轮会打开所有的灯泡，第二轮关闭所有偶数次序的灯泡，第三轮翻转所有次序为三的倍数位置的灯泡，直到第n轮拨动最后一个灯泡的开关。
 * 试确定第n轮后还有几盏灯是亮的。
 */
public class BulbSwitcher {

    /**
     * 1．对于每盏灯，拉动的次数是奇数时，灯就是亮着的，拉动的次数是偶数时，灯就是关着的。
     * 2．每盏灯拉动的次数与它的编号所含约数的个数有关，它的编号有几个约数，这盏灯就被拉动几次。
     * 3．1——100 这 100 个数中有哪几个数，约数的个数是奇数。我们知道一个数的约数都是成对出现的，只有完全平方数约数的个数才是奇数个。
     * <p>
     * 所以这 100 盏灯中有 10 盏灯是亮着的。
     * 它们的编号分别是： 1、4、9、16、25、36、49、64、81、100。
     */
    public int bulbSwitch(int n) {
        // 计算一个数之下有多少小于或等于它的平方数，使用一个开平方用的函数就可以了
        return (int) (n >= 0 ? Math.sqrt(n) : 0);
    }


    // 暴力法
    private static int count = 0;
    public static void main(String[] args) {
        int a[] = new int[100];//100盏灯的状态
        Arrays.fill(a, 0);
        for (int i = 1; i <= a.length; i++) {//100个人
            for (int j = 0; j < a.length; j++) {//100盏灯
                if ((j + 1) % i == 0) {//第（j+1）盏灯对于被第i个人的行为后的状态。
                    if (a[j] == 0) {//原来的状态取反
                        a[j] = 1;
                    } else {
                        a[j] = 0;
                    }
                }
            }
        }
        for (int c : a) {
            if (c == 1) {
                count++;
            }
        }
        System.out.println(count);


    }
}
