/*******************************************************************************
 * Purpose/Description: Searches through an array who first strictly increases
                        and then decreases for an integer value. For simplicity,
                        I have limited the size of the array to be from 10 to 30
                        elements, and it only increases or decreases by 1 to 9 on
                        each step. I have done this because the focus of the program
                        is on the actual search, not the array itself.
 * Author's Panther ID: 5160328
 * Certification:
    I hereby certify that this work is my own and none of it is the work of any
    other person.
 * QUESTION (b): The time complexity of my search algorithm is O(n).
 * Please refer to the "findInt" static method to view the algorithm.
 * It involves 1 while loop which ends when the array element is found or the
 * end of the array is reached (array is size n).
 * In the best case, the integer is found in array index "0".
 * In the worst case, the integer is either found at index "n-1" or not found
 * at all, i.e. the complexity of the while loop is "n".
 * The if statement is insignificant, since it does not depend on the input size,
 * and therefore has a constant complexity.
 * T(n) = n + c, where "n" is the complexity of the while loop, and "c" of the if statement
 * as n -> infinity.
 * Therefore, T(n) belongs to O(n).
 * Please not for T(n), I did not include the actual constant values that scale "n" as they
 * are insignificant as n -> infinity.
*******************************************************************************/


import java.util.Random;
import javax.swing.JOptionPane;

public class ProblemOne {
    
    // <--------------------------------------------------------------->
    // <-------THIS IS THE METHOD THAT IMPLEMENTS THE ALGORITHM!------->
    // <--------------------------------------------------------------->
    // Returns the index of the element if it is found, else -1.
    private static int findInt(int [] a, int intToFind)
    {
       boolean found = false;
       int i = 0;
       
       // Iterate through array until it is found.
       while(!found && i < a.length)
       {
           // If the current element is the integer being searched for,
           // return the index of the element.
           if(a[i] == intToFind)
           {
               found = true;
               return i;
           }
           else
           {
               i++;
           }
       }
        return -1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] a; // Array that will strictly increase and strictly decrease.
        int n; // Amount of elements in the array.
        int increaseAmt; // Num of elements before array begins to decrease.
        String rawInput; // Number to search for, inputed by user.
        int input; // converted rawInput to integer.
        int foundIndex; // Index of where the input was found in the array.
        
        int minSize = 10; //Minimum size of elements in the array.
        int maxSize = 30; //Max size of elements in the array.
        int currentNum = 1; //Used to hold current value.
        Random rand = new Random(); // Random generator.
        
        //<--------------------------------------------------------->
        //<---------LINES 80 - 115 SIMPLY GENERATE THE ARRAY--------->
        //<--------------PLEASE SKIP TO BELOW LINE 120:-------------->
        //<--------------------------------------------------------->
        
        n = rand.nextInt(maxSize - minSize + 1) + minSize;
        
        // Generating an array that strictly increases then strictly decreases
        // Array is from 10 to 30 elements
        
        //Creating the array of n elements.
        a = new int[n];
        increaseAmt = rand.nextInt(n - 2) + 2; //Num from 2 to n - 1

        //Populating array with strictly increasing to strictly decreasing numbers.
        for(int i=0; i<a.length; i++)
        {
            if(i <= increaseAmt - 1)
            {
                currentNum += rand.nextInt(9) + 1; 
            }
            else
            {
                currentNum -= rand.nextInt(9) + 1;
            }
            a[i] = currentNum;
        }
        
        System.out.println("Array Size: " + a.length);
        System.out.println("Number of elements that strictly increase: " + increaseAmt + "\n");
        System.out.println("Index | Element");
        System.out.println("---------------");
        for(int i=0; i<a.length; i++)
        {
            System.out.printf("%6d| %d", i, a[i]);
            if(i == increaseAmt)
            {
                System.out.print(" <--- Decreasing Starts");
            }
            System.out.print("\n");
        }
        
        //<--------------------------------------------------------->
        //<---------------Problem 1 LETTER (a) BEGINS--------------->
        //<--------------------------------------------------------->
        rawInput = JOptionPane.showInputDialog("Please enter an integer to search for.");
        
        try
        {
            input = Integer.parseInt(rawInput);
            System.out.println("Searching for: " + input + " ....");
            foundIndex = findInt(a, input); // "findInt()" is the actual method that implements the algo.
            
            if(foundIndex == -1)
            {
                System.out.println("Sorry! The integer is not in the array.");
            }
            else
            {
                System.out.println("The element was found at index: " + foundIndex);
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Sorry! That was not a valid integer. Exiting...");

        }
    }
}
