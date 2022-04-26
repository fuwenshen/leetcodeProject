package com.frank.mianshi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName Huawei2.java
 * @Description TODO
 * @createTime 2022年04月25日 19:39:00
 */
public class Huawei2 {

    /**
     * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
     *
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
     */

    public static void main(String[] args) {

        String[] words = {"caaa","bbb","caaa","bbb","bbb","ccc","ccc"};

        List<String> res = outMoreWords(words, 2);
        System.out.println(res);

    }
    public static List<String> outMoreWords(String[] words, int k) {
        Map<String, Integer> map = new TreeMap();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Integer count = map.get(word) !=null?  map.get(word)+1:1;

            map.put(word, count);

            if(queue.size()<k){
                queue.add(count);
            }else if( queue.peek() <count ){
                queue.poll();
                queue.add(count);
            }

        }

        int value = queue.peek();

        List<String> list = map.entrySet().stream()
                .filter((entry) -> (value == entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return list;
    }
}
