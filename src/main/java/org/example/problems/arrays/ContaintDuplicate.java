package org.example.problems.arrays;
/*Given an integer array nums, return true if any value appears at least twice in the array, and
 return false if every element is distinct*/

import java.util.Arrays;

/*
 * Thus I need to identify if by any case in the whole array there are any duplicated values.
 ? Do  I have to examine every element of the array? R// Nop, however worst case scenario could
 ? mean that
 ! Have to sort the array that way will be simple to find any duplicated value

 * Steps to solve the problem
 * 1. Validate the array is bigger than 2
 * 2. Sort the array
 * 3. Validate a duplicated is stored.
 */
public class ContaintDuplicate
{
    public static void main(String[] args)
    {
        boolean value = containsDuplicatedVersion2(new int[] {1,5,-2,-4, 0});
        System.out.println(value);
    }

    public static boolean containsDuplicate(int[] nums)
    {
        if (nums.length == 2)
        {
            return (nums[0] == nums[1]);
        }
        if (nums.length <= 1)
        {
            return false;
        }

        nums = Arrays.stream(nums).sorted().toArray();

        int index = 0;
        boolean duplicate = false;
        System.out.println(Arrays.toString(nums));
        while (!duplicate && index < nums.length)
        {
            int testingValue = nums[index++];
            for (int i = index; i < nums.length; i++)
            {
                if (testingValue == nums[i])
                {
                    duplicate = true;
                    break;
                }
            }
        }
        return duplicate;
    }

    /* Solution above works, however It exceeds the time limit hence It's not approved
     * I'm doing a O(x^2) version. Above. By Sorting first. Then Going over every possible value
     * and validating against every other. Thus It takes way to long.
     ? What to do in order to avoid that much time.
     ! Sort is a great Idea.
     * Since It's sort there is no need to verify one value against all other, If there is a
     * duplicated It must be one position above or behind of the element already reviewed.
     * Hence I only need to review elements close to the main position.
     *
     */

    public static boolean containsDuplicatedVersion2(int[] nums)
    {
        if (nums.length == 2)
        {
            return (nums[0] == nums[1]);
        }
        if (nums.length <= 1)
        {
            return false;
        }
        int lastPosition = nums.length - 1;
        int index = 1;
        nums = Arrays.stream(nums).sorted().toArray();

        while (index < lastPosition)
        {
            if (validation(nums,index))
            {
                return true;
            }
            System.out.println(
                (((nums.length - 1) - index) / 2) + "-" + ((nums.length - 1) + index) / 2);
            System.out.println(index);
            index ++;
        }
        return false;
    }

    public static boolean validation(int [] nums, int position) // ! This doesn't work either. In
    // cases where
    {
        int currentPosition = position;
        int previousPosition = (position - 1 ) <= 0 ? 0 : (position - 1 ) ;
        return nums[position] == nums[position - 1] || nums[position] == nums[position + 1];
    }
    // TODO NEEDS TO WORK ON SORTING ALGORITHMS
}
