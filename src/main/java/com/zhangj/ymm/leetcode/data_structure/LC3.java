package com.zhangj.ymm.leetcode.data_structure;

import java.util.HashSet;

/**
 * @author zhangj
 * @date 2019/5/13
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * "abcabcbb"
 */
public class LC3 {

    public static void main(String[] args) {
        System.out.println(8 & 7);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int start = 0, end = 0;
        HashSet<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }
        return res;
    }
}
