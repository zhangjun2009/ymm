package com.zhangj.ymm.leetcode;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * @author zhangj
 * @date 2019/5/8
 */
public class LC1 {
    public static void main(String[] args) {
        int[] array = new int[10000000];
        IntStream.range(0, 10000000).forEach(i -> array[i] = i);
        int target = 50000;
        long start = System.currentTimeMillis();
        twoSum1(array, target);
        System.out.println("耗时:" + (System.currentTimeMillis() - start) + "ms");
        //Arrays.stream(twoSum2(array, target)).forEach(System.out::println);
    }

    public static int[] twoSum1(int[] array, int target) {
        int[] result = new int[2];
        scan:
        {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; i < array.length; j++) {
                    if (array[i] + array[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        break scan;
                    }
                }
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];
            int otherVal = target - currentVal;
            if (null != map.get(otherVal) && map.containsKey(otherVal) && i != map.get(otherVal)) {
                result[0] = i;
                result[1] = map.get(otherVal);
                break;
            }
        }
        return result;
    }
}
