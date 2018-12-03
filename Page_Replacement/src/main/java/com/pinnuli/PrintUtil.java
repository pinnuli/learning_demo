package com.pinnuli;

import java.text.DecimalFormat;

/**
 * @author: pinnuli
 * @date: 2018-12-03
 */

public class PrintUtil {

    /**
     * 输出指令地址流
     * @param instructionsSequence 指令地址流
     */
    public static void showInstructionsSequence(int[] instructionsSequence) {
        System.out.println("系统随机生成的指令地址序列如下：");
        for (int i = 0; i < instructionsSequence.length; i++) {
            System.out.printf("%5s", instructionsSequence[i]);

            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    /**
     * 输出页地址流
     * @param pagesSequence 页地址流
     */
    public static void showPagesSequence(int[] pagesSequence) {
        System.out.println("该指令地址序列对应的页号序列如下：");
        for (int i = 0; i < pagesSequence.length; i++) {
            System.out.printf("%5s", pagesSequence[i]);

            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();

        System.out.println("实际总共使用到的页号个数为：" + pagesSequence.length);
        System.out.println();
    }

    /**
     * 输出命中率
     * @param pagesSequence 页地址流
     * @param lackTimes 缺页次数
     */
    public static void showHitRate(int[] pagesSequence, int lackTimes) {
        double hitRate = (double) (pagesSequence.length - lackTimes) / pagesSequence.length;
        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.printf("%-12s", df.format(hitRate));
    }
}
