package com.pinnuli;

import java.util.ArrayList;

/**
 * 页面置换算法模拟实现主类
 * @author: pinnuli
 * @date: 2018-12-03
 */

public class PageReplacement {

    /**
     * 指令条数
     */
    public static final int INSTRUCTIONS_NUM = 400;

    /**
     * 页面大小,每个页面可包含instructionsNumPerPage条指令
     */
    public static int instructionsNumPerPage = 10;

    /**
     * 存放该程序依次执行的指令的有序地址序列
     */
    public static int[] instructionsSequence = null;

    /**
     * 存放将有序指令地址序列转换成(经过合并相邻页号)的有序页号序列
     */
    public static int[] pagesSequence = null;

    /**
     * 指定分配给该程序的内存块数
     */
    public static int memoryBlocksNum;

    public static void main(String[] args) {

        instructionsSequence = generateInstructionsSequence(INSTRUCTIONS_NUM);
        PrintUtil.showInstructionsSequence(instructionsSequence);


        pagesSequence = convertToPagesSequence(instructionsSequence, instructionsNumPerPage);
        PrintUtil.showPagesSequence(pagesSequence);

        System.out.printf("%-10s", "页框数");
        System.out.printf("%-10s", "FIFO命中率");
        System.out.printf("%-10s", "LRU命中率");
        System.out.printf("%-10s", "OPT命中率");
        System.out.println();

        for (memoryBlocksNum = 4; memoryBlocksNum <= 40; memoryBlocksNum++) {
            String memoryBlocksNumString = "[" + memoryBlocksNum + "]";
            System.out.printf("%-12s", memoryBlocksNumString);
            ReplacementAlgorithm.FIFO(pagesSequence, memoryBlocksNum);
            ReplacementAlgorithm.LRU(pagesSequence, memoryBlocksNum);
            ReplacementAlgorithm.OPT(pagesSequence, memoryBlocksNum);
            System.out.println();
        }

        System.out.println("\n\n");

    }

    /**
     * 前半部分地址，从[0,199]中随机选一数m,记录到地址流数组中，接着的执行地址为m+1;
     * 后半部分地址，从[200,399]中随机选一数m',记录到地址流数组中，接着的执行地址为m'+1;
     * 重复以上，知道产生400条指令
     * @param instructionsNum 指令条数
     * @return 返回生成的指令流
     */
    public static int[] generateInstructionsSequence(int instructionsNum) {
        int[] instructionsSequence = new int[instructionsNum];

        int count = 0;
        int halfInstructNum = instructionsNum / 2;

        while (count < halfInstructNum) {
            //生成前半部分的指令
            int randomAddress1 = (int) (Math.random() * halfInstructNum);
            instructionsSequence[count] = randomAddress1;
            instructionsSequence[++count] = ++randomAddress1;

            //生成后半部分的指令,这里应该只可以加上总条数的一半减一，不然就可能会产生地址为401的指令
            int randomAddress2 = (int) (Math.random() * halfInstructNum + halfInstructNum - 1);
            instructionsSequence[count + halfInstructNum - 1] = randomAddress2;
            instructionsSequence[count + halfInstructNum] = ++randomAddress2;

            count++;
        }

        return instructionsSequence;
    }



    /**
     * 将指令地址流换成页地址流
     * @param instructionsSequence   指令地址流
     * @param instructionsNumPerPage 每页存放指令条数
     * @return 返回合并后的页地址流
     */
    public static int[] convertToPagesSequence(int[] instructionsSequence, int instructionsNumPerPage) {
        ArrayList<Integer> pagesList = new ArrayList<Integer>();
        int temp = -1;
        //页号
        int pageIndex;

        for (int i = 0; i < instructionsSequence.length; i++) {
            pageIndex = instructionsSequence[i] / instructionsNumPerPage;

            //将相邻的页号合并
            if (pageIndex != temp) {
                pagesList.add(pageIndex);
                temp = pageIndex;
            }
        }

        //有序页号序列经合并之后长度最长不超过指令的有序地址序列长度
        int[] pagesSequence = new int[pagesList.size()];

        for (int i = 0; i < pagesList.size(); i++) {
            pagesSequence[i] = pagesList.get(i);
        }

        return pagesSequence;
    }
}


