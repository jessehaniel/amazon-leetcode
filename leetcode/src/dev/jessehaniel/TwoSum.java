package dev.jessehaniel;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {

    // Given an array of integers `nums` and an integer `target`,
    // return indices of the two numbers such that they add up to `target`.
    // You may assume that each input would have `exactly one solution`,
    // and you may not use the same element twice.
    // You can return the answer in any order.

    public Integer[] bruteForce(Integer[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new Integer[]{i, j};
                }
            }
        }
        return new Integer[]{};
    }

    public Integer[] optimal(Integer[] nums, int target) {
        Map<Integer, Integer> map = IntStream.range(0, nums.length)
            .boxed()
            .collect(Collectors.toMap(i -> nums[i], i -> i, (a, b) -> b));

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new Integer[] { i, map.get(complement) };
            }
        }
        return new Integer[]{};
    }

    public static void main(String[] args) {
        TwoSum app = new TwoSum();

        app.twoSum(app::bruteForce, new Integer[]{2, 7, 11, 15}, 9);//[0,1]
        app.twoSum(app::bruteForce, new Integer[]{3, 2, 4}, 6);//[0,1]
        app.twoSum(app::bruteForce, new Integer[]{3, 3}, 6);//[0,1]

        app.twoSum(app::optimal, new Integer[]{2, 7, 11, 15}, 9);//[0,1]
        app.twoSum(app::optimal, new Integer[]{3, 2, 4}, 6);//[0,1]
        app.twoSum(app::optimal, new Integer[]{3, 3}, 6);//[0,1]

    }

    private void twoSum(BiFunction<Integer[], Integer, Integer[]> func, Integer[] nums, Integer target) {
        Instant start = Instant.now();
        Integer[] ints = func.apply(nums, target);
        System.out.println(Arrays.toString(ints));
        System.out.println(Duration.between(start, Instant.now()).toNanos() + "ns.");
    }

}
