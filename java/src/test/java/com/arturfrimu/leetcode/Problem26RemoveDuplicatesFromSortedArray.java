package com.arturfrimu.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem26RemoveDuplicatesFromSortedArray {


    public int removeDuplicates(int[] nums) {
        Queue<Integer> queue = Arrays.stream(nums).boxed()
                .collect(Collectors.toCollection(TreeSet::new)).stream()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int result = queue.size();

        for (int i = 0; i < nums.length; i++) {
            Integer value = queue.poll();
            if (value != null) {
                nums[i] = value;
            } else {
                nums[i] = 0;
            }
        }

        return result;
    }


    @Test
    void remove() {
        assertEquals(2, removeDuplicates(new int[]{1, 1, 2}));
        assertEquals(3, removeDuplicates(new int[]{1, 2, 2, 3}));
        assertEquals(5, removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    @Test
    void test() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
