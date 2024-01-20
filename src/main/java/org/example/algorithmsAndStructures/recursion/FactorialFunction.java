package org.example.algorithmsAndStructures.recursion;

import java.util.Scanner;

public class FactorialFunction {
    public static void main(String[] args) {
        System.out.println(factorialFunction(5));
    }

    public static int factorialFunction(int n){
        //In case n == 0 the return is 1
        Scanner input = new Scanner(System.in);

        if( n==0){
            return 1;
        }
        if (n<0){
            System.out.println("The value submite is not valid. Try it again. Remember must be positive");
            input.nextInt();
        }

        return n * factorialFunction(n-1);
    }
}
