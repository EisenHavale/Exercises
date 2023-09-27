package org.example.capitalizeInitials;

import java.util.List;
import java.util.stream.Collectors;

public class SolutionImplementations
{
    private static final String REGEX = " ";

    /*
     *Create a method able to capitalize every initial of a word
     ? How to get first letter of every word?
     * Should use a regEx to identify first letter and thru possibly a map change toUpperCase
     */
    public static void main(String[] args)
    {
        String sentence = "How can mirrors be real if our eyes aren't real";

        System.out.println(capitalizeInitials(List.of(sentence.split(REGEX))));
    }

    private static String capitalizeInitials(List<String> wordLists)
    {
        wordLists =
            wordLists.stream()
                .map(word -> (word.substring(0, 1).toUpperCase()) + word.substring(1))
                .collect(Collectors.toList());

        StringBuilder joint = new StringBuilder();

        for (String word : wordLists)
        {
            joint.append(word).append(" ");
        }
        return joint.toString();
    }
}
