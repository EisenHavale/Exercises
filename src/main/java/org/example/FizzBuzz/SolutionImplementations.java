package org.example.FizzBuzz;

public class SolutionImplementations
{
    private static final Integer FIZZDIVISIONFACTOR = 3;
    private static final Integer BUZZDIVISIONFACTOR = 5;
    
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    
    public static void main(String[] args)
    {
        for (int i = 1; i < 100; i++)
        {
            System.out.println(fizzBuzz(i));
        }
    }
    
    private static String fizzBuzz(int index)
    {
        String message = "";
        message += fizzBuzzValidation(index, FIZZDIVISIONFACTOR, FIZZ);
        message += fizzBuzzValidation(index, BUZZDIVISIONFACTOR, BUZZ);
        return message.equals("") ? String.valueOf(index) : message;
    }
    
    private static String fizzBuzzValidation(
        int index,
        int factor, String message)
    {
        return (index % factor == 0) ? message : "";
        
    }
    
    
}
