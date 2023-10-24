package org.example.problems.arrays;

import java.util.Arrays;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */

/*
 ? What to do??
 ! I can't go thru the array using steps as an index.
 * Steps minus array length will be how many numbers will be located at the front.
 * The steps to do can be bigger than length. That's why it's important to avoid repeating.
 * In cases like 3 steps for a 2 length it's actyally 1 step.
 ? What if steps is higher than length?
  */
public class RotateArray
{
    public static void main(String[] args)
    {
        int[] array = new int[] {1, 2, 3};

        System.out.println(Arrays.toString(array));
        solution(array, 4);
    }

    public static void rotateArray(int[] array, int steps)
    {
        if (array.length > 1)
        {
            int firstPosition = 0;
            int initialValue = (array.length - steps); // Here it's
            // the key.
            int[] auxiliaryArray = new int[array.length];
            if (initialValue < 0 && steps > 1) // !Works fine for cases where length is higher that
            // steps.
            {
                for (int i = 0; i <= array.length - 1; i++)
                {
                    if (i < steps && array.length > initialValue)
                    {
                        auxiliaryArray[i] = array[initialValue++];
                    }
                    if (i >= steps)
                    {
                        auxiliaryArray[i] = array[firstPosition++];
                    }
                }
                System.arraycopy(auxiliaryArray, 0, array, 0, array.length);
                System.out.println(Arrays.toString(array));
                return;
            }
            if (steps == 1) // ! Doesn't work for cases where steps are bigger
            {
                int[] auxiliary = array.clone();
                array[0] = array[array.length - 1];
                System.arraycopy(auxiliary, 0, array, 1, array.length - 1);
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void solution(int [] nums, int k)
    {
        int lastPosition = nums.length -1;
        k%= nums.length;//! This is done to identify the real amount  of needed changes. Taking
        //!into account sometimes It's not exactly same as k in cases where k is higher tha length
        reverseArray(nums,  Math.abs(nums.length - k), lastPosition);
        reverseArray(nums, 0, (lastPosition - k ));
        reverseArray(nums, 0, lastPosition);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverseArray(int [] nums, int startingPoint, int endingPoint)
    {
        while (startingPoint <= endingPoint)
        {
            int temp = nums[startingPoint];
            nums[startingPoint] = nums[endingPoint];
            nums[endingPoint] =temp;
            startingPoint++;
            endingPoint--;
        }
    }

}
