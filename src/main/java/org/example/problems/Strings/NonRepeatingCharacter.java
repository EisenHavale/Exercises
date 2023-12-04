package org.example.problems.Strings;

/**
 * Write a function that takes in a string of lower case english alphabet letters and returns
 * the index of the string's first non-repeating character
 * 1. Need to convert the string into a char array
 * 2. Avoid repetition
 */
public class NonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(findNotRepeatingCharacter("abcdfgee"));
    }
//[a,b,c,d,e,f,g]
    public static int findNotRepeatingCharacter( String letters){
        char[] lettersArray = letters.toCharArray();
        for (int i = 0; i < lettersArray.length - 1; i++) {
            char currentLetter = lettersArray[i];
            for (int j = i+1; j < lettersArray.length; j++) {
                if(currentLetter == lettersArray[j]){
                    return i;
                }
            }
        }
        return -1;
    }
}
