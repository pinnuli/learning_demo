package com.pinnuli;

import java.util.Arrays;

/**
 * 置换算法
 * @author: pinnuli
 * @date: 2018-12-03
 */

public class ReplacementAlgorithm {
    public static void FIFO(int[] pagesSequence, int memoryBlocksNum) {
        //执行页号序列期间内存块的状态
        int[][] memoryBlocksState = new int[pagesSequence.length][memoryBlocksNum];

        //该指针指向将要被置换的内存块的位置（下标位置）
        int curPosition = 0;

        //执行每个页号时内存块序列的状态
        int[] tempState = new int[memoryBlocksNum];

        //记录缺页情况， 1表示缺页，0表示不缺页
        int[] isLackOfPage = new int[pagesSequence.length];
        Arrays.fill(isLackOfPage, 0, pagesSequence.length, 0);

        //缺页次数
        int lackTimes = 0;

        //开始时，内存块状态都为空闲（-1表示）
        Arrays.fill(tempState, 0, memoryBlocksNum, -1);

        for (int i = 0; i < pagesSequence.length; i++) {
            //如果缺页
            if (findKey(tempState, 0, memoryBlocksNum - 1, pagesSequence[i]) == -1) {
                //如果内存块没有剩余
                if (tempState[memoryBlocksNum - 1] != -1) {
                    isLackOfPage[i] = 1;
                    lackTimes++;
                }
                tempState[curPosition] = pagesSequence[i];

                //指针向右移动超过memoryBlocksNum时，重置其指向开始的内存块位置0
                if (curPosition + 1 > memoryBlocksNum - 1) {
                    curPosition = 0;
                } else {
                    curPosition++;
                }
            }

            //保存当前内存块序列的状态
            System.arraycopy(tempState, 0, memoryBlocksState[i], 0, memoryBlocksNum);

        }

        PrintUtil.showHitRate(pagesSequence, lackTimes);
    }

    public static void LRU(int[] pagesSequence, int memoryBlocksNum) {
        //维护一个最近使用的内存块集合
        LRULinkedHashMap<String, Integer> recentVisitedBlocks = new LRULinkedHashMap<String, Integer>(memoryBlocksNum);

        //执行页号序列期间内存块的状态
        int[][] memoryBlocksState = new int[pagesSequence.length][memoryBlocksNum];

        //该指针指向将要被置换的内存块的位置（下标位置）
        int curPosition = 0;

        //执行每个页号时内存块序列的状态
        int[] tempState = new int[memoryBlocksNum];

        //记录缺页情况， 1表示缺页，0表示不缺页
        int[] isLackOfPage = new int[pagesSequence.length];
        Arrays.fill(isLackOfPage, 0, pagesSequence.length, 0);

        //缺页次数
        int lackTimes = 0;

        //开始时，内存块状态都为空闲（-1表示）
        Arrays.fill(tempState, 0, memoryBlocksNum, -1);

        for (int i = 0; i < pagesSequence.length; i++) {
            //如果页地址不在内存中
            if (findKey(tempState, 0, memoryBlocksNum - 1, pagesSequence[i]) == -1) {
                //如果内存块还有剩余
                if (tempState[memoryBlocksNum - 1] == -1) {
                    tempState[curPosition] = pagesSequence[i];
                    recentVisitedBlocks.put(String.valueOf(pagesSequence[i]), pagesSequence[i]);
                    curPosition++;
                }
                //如果内存块都已被使用，说明缺页
                else {
                    isLackOfPage[i] = 1;
                    lackTimes++;
                    //找到当前内存块序列中最近最少使用的内存块，并将其置换
                    curPosition = findKey(tempState, 0, memoryBlocksNum - 1, recentVisitedBlocks.getHead());
                    tempState[curPosition] = pagesSequence[i];
                    recentVisitedBlocks.put(String.valueOf(pagesSequence[i]), pagesSequence[i]);
                }
            }
            //如果页地址在内存中
            else {
                //将这里被使用的pageSequence[i]在最近使用的内存块集合中的原先位置调整到最近被访问的位置
                recentVisitedBlocks.get(String.valueOf(pagesSequence[i]));
            }

            //保存当前内存块序列的状态
            System.arraycopy(tempState, 0, memoryBlocksState[i], 0, memoryBlocksNum);
        }

        PrintUtil.showHitRate(pagesSequence, lackTimes);
    }

    public static void OPT(int[] pagesSequence, int memoryBlocksNum) {
        //执行页号序列期间内存块的状态
        int[][] memoryBlocksState = new int[pagesSequence.length][memoryBlocksNum];

        //该指针指向将要被置换的内存块的位置（下标位置）
        int curPosition = 0;

        //执行每个页号时内存块序列的状态
        int[] tempState = new int[memoryBlocksNum];

        //记录缺页情况， 1表示缺页，0表示不缺页
        int[] isLackOfPage = new int[pagesSequence.length];
        Arrays.fill(isLackOfPage, 0, pagesSequence.length, 0);

        //缺页次数
        int lackTimes = 0;

        //开始时，内存块状态都为空闲（-1表示）
        Arrays.fill(tempState, 0, memoryBlocksNum, -1);

        for (int i = 0; i < pagesSequence.length; i++) {
            //如果缺页
            if (findKey(tempState, 0, memoryBlocksNum - 1, pagesSequence[i]) == -1) {

                //如果内存块还有剩余，最后一个依然是-1表示还有剩余
                if (tempState[memoryBlocksNum - 1] == -1) {
                    tempState[curPosition] = pagesSequence[i];
                    curPosition++;
                }
                //如果内存块都已被使用
                else {
                    isLackOfPage[i] = 1;
                    lackTimes++;

                    int maxLoc = 0;

                    for (int j = 0; j < memoryBlocksNum; j++) {
                        //找出当前内存块序列中的内存块tempState[j]在将来会被访问到的（第一个）位置
                        int loc = findKey(pagesSequence, i + 1, pagesSequence.length - 1, tempState[j]);

                        //如果将来该内存块都不再被使用了
                        if (loc == -1) {
                            curPosition = j;
                            break;
                        }
                        //找出当前内存块序列中的所有内存块在将来会被访问到的最远位置，设为maxLoc
                        else {
                            if (maxLoc < loc) {
                                maxLoc = loc;
                                curPosition = j;
                            }
                        }
                    }

                    tempState[curPosition] = pagesSequence[i];
                }
            }

            //保存当前内存块序列的状态
            System.arraycopy(tempState, 0, memoryBlocksState[i], 0, memoryBlocksNum);
        }

        PrintUtil.showHitRate(pagesSequence, lackTimes);
    }

    /**
     * 返回key在arr中第一次出现的位置,start和end为数组下标, 找不到则返回-1
     * @param arr 要查找的数组
     * @param start 开始查找的未知
     * @param end 结束查找的未知
     * @param key 要查找的对象
     * @return key在arr中第一次出现的位置, 找不到则返回-1
     */
    public static int findKey(int[] arr, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }
}
