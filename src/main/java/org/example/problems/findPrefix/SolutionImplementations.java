package org.example.problems.findPrefix;
/*

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
----------

Input: strs = ["flower","flow","flight"]

Output: "fl"

Example 2:

----------

Input: strs = ["dog","racecar","car"]

Output: ""

Explanation: There is no common prefix among the input strings.

Constraints:

-------------

1 <= strs.length <= 200

0 <= strs[i].length <= 200

strs[i] consists of only lowercase English letters.

1. Get from first string a value, save index and share it, double check it exists in the other
strings ( 1 Function)

2. Validate if other strings has this in the same position. Another function,

3. store what I find. Should be done in the function above

 */

public class SolutionImplementations
{
    private static final String[] FIRST_INPUT = {"dog","racecar","car"};
    private static final String[] SECOND_INPUT = {"dog","racecar","car"};

    public static void main(String[] args)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < FIRST_INPUT[0].length(); i++)
        {
            String value = findMatchingValues(i);
            if(value == null){
                break;
            }
            result.append(value);
        }
        System.out.println(result);
    }

    private static Character getLetter(int letterIndex, int arrayIndex)
    {
        if ((FIRST_INPUT[arrayIndex].length() - 1) >= letterIndex)
        {
            return FIRST_INPUT[arrayIndex].charAt(letterIndex);
        }
        return null;
    }

    private static String findMatchingValues(int letterIndex)
    {
        int arrayIndex = FIRST_INPUT.length - 1;

        if (FIRST_INPUT.length == 0 && FIRST_INPUT[arrayIndex].length() == 0)
        {
            return "";
        }

        Character firstValue = FIRST_INPUT[arrayIndex].charAt(letterIndex);

        boolean areEqual = true;
        while (arrayIndex > 0 && areEqual)
        {
            areEqual = firstValue.equals(getLetter(letterIndex, --arrayIndex));
        }

        return areEqual ? String.valueOf(firstValue) : null;
    }
}
