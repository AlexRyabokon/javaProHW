package org.hillel.optionalhw4;

public class RecursionTwo {

    /*Task1
    Given an array of ints, is it possible to divide the ints into two groups, so that the sum of one group is
    a multiple of 10, and the sum of the other group is odd. Every int must be in one group or the other.
    Write a recursive helper method that takes whatever arguments you like, and make the initial call to
     your recursive helper from splitOdd10(). (No loops needed.)
    * */


    public boolean splitOdd10(int[] nums) {
        return splitOdd10(0, nums, 0, 0);
    }

    public boolean splitOdd10(int start, int[] nums, int mult, int odd) {
        if (start >= nums.length)
            return mult % 10 == 0 && odd % 2 == 1;

        if (splitOdd10(start + 1, nums, mult + nums[start], odd))
            return true;

        return splitOdd10(start + 1, nums, mult, odd + nums[start]);
    }


    /*Task2
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of the two groups is
     *  the same, with these constraints: all the values that are multiple of 5
     * must be in one group, and all the values that are a multiple of 3
     * (and not a multiple of 5) must be in the other. (No loops needed.)*/

    public boolean split53(int[] nums) {
        return split53(0, nums, 0, 0);
    }

    public boolean split53(int start, int[] nums, int mult5, int mult3) {
        if (start >= nums.length)
            return mult5 == mult3;

        switch (nums[start] % 5) {
            case 0:
                return split53(start + 1, nums, mult5 + nums[start], mult3);
            case 3:
                return split53(start + 1, nums, mult5, mult3 + nums[start]);
            default:
                if (split53(start + 1, nums, mult5 + nums[start], mult3))
                    return true;
                else
                    return split53(start + 1, nums, mult5, mult3 + nums[start]);
        }
    }

    /*Task3
    Given an array of ints, is it possible to choose a group of some of the
     ints, such that the group sums to the given target with this additional
     constraint: If a value in the array is chosen to be in the group, the
     value immediately following it in the array must not be chosen. (No loops
      needed.)
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length)
            return target == 0;

        if (groupNoAdj(start + 2, nums, target - nums[start])) {
            return true;
        } else {
            return groupNoAdj(start + 1, nums, target);
        }
    }
}
