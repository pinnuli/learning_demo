package com.pinnuli;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: pinnuli
 * @date: 2018-12-03
 */

public class LRULinkedHashMap <K, V> extends LinkedHashMap<K, V>
{
    //最大内存块数（容量）
    private int maxMemoryBlocksNum;

    //设置默认负载因子
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public LRULinkedHashMap(int maxCapacity)
    {
        //设置accessOrder为true，保证了LinkedHashMap底层实现的双向链表是按照访问的先后顺序排序
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxMemoryBlocksNum = maxCapacity;
    }

    //得到最近最少被访问的元素
    public V getHead()
    {
        return (V) this.values().toArray()[0];
    }

    //移除多余的最近最少被访问的元素
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
    {
        return size() > maxMemoryBlocksNum;
    }
}
