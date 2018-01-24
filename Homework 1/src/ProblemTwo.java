/*******************************************************************************
 * Purpose/Description: Finds the number of times that an integer occurs in
                        a given sorted array. For the simplicity of this assignment,
                        The array is always of size "20", and will only contain
                        integers between -10 and 10.
 * Author's Panther ID: 5160328
 * Certification:
    I hereby certify that this work is my own and none of it is the work of any
    other person.
 * QUESTION (b): The time complexity of my implemented algorithm is O(n).
 * Please refer to the static method "intOccur" to view the algorithm.
 * Everything outside of the for loop uses constant time complexity, so it is 
 * not significant as n -> infinity.
 * Looking at the for loop, we can see it has complexity "n" (the length of the array)
 * because it only increments by 1, and loops from 0 to n-1. Looking at the if/else
 * statement, the actual contents of them use constant time, as they do not 
 * depend on the input size "n".
 * Therefore, T(n) = n + c, where "n" is the size of the array, and "c" is the 
 * cost of initializations, and return statements, so T(n) is O(n).
 * Please note for T(n), I did not include the actual constant values that scale "n" as they
 * are insignificant as n -> infinity.
*******************************************************************************/
import java.util.Random;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ProblemTwo {

    // <--------------------------------------------------------------->
    // <-------THIS IS THE METHOD THAT IMPLEMENTS THE ALGORITHM!------->
    // <--------------------------------------------------------------->
    // Searches a sorted array for the occurences of an intenger, and returns the
    // ammount of times that integer is found.
    private static int intOccur(int [] a, int intToFind)
    {
        int occurences; // Amount of times that integer is found.
        int prevNum; // Hold previous number.
        
        occurences = 0;
        prevNum = 0;
        
        /* Increment occurences counter if current element is the integer being
         * searched for.
         * Since the array is sorted, once the consecutive (1 or more) intToFind 
         * integer block has been passed, simply stop counting, as there are no
         * more "intToFind" values in the array, since it is strictly increasing. 
        */
        for(int i=0; i < a.length; i++)
        {
            if(a[i] == intToFind)
            {
                occurences++;
            }
            else if(a[i] != prevNum && occurences >= 1)
            {
                break; //Exit, since "intToFind" consecutive block has passed.
            }
            
            // Store current number to save for next iteration.
            prevNum = a[i]; 
        }
        
        return occurences;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] a = new int [20]; // Array to search, of size 20.
        String rawInput; // Holds user's number to search for in string form.
        int input; // Holds the user's input converted to an integer.
        Random rand = new Random();
        
        //Populating array with random numbers from -10 to 10.
        for(int i=0; i < a.length; i++)
        {
            a[i] = rand.nextInt(21) - 10;
        }
        
        Arrays.sort(a); //Sort the array.
        
        //Print out Array.
        System.out.println("Generated Array: ");
        for(int i=0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
        
        rawInput = JOptionPane.showInputDialog("Which integer would you like "
                + "to know how many there are of in the array?");
        
        try
        {
            input = Integer.parseInt(rawInput);
            //"intOccur" is the method that implements the algorithm for Problem #2.
            System.out.println("The number was found " + intOccur(a, input) 
                    + " time(s) in the array.");
            
        }
        catch (NumberFormatException e)
        {
            System.out.println("Sorry! That input was not a valid integer.");
        }
    }
}
