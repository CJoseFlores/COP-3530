/*********************************************************************
 Purpose/Description: CHANGE THIS BEFORE SUBMISSION.
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 * Questions:
 * PART (A): The algorithm for my implemented linearSort() is O(n) because
 * it iterates through the entire array to count the number of zeroes (which 
 * is O(n)) and then it iterates through the array one more time and 
 * overrides the values with 0's or 1's, which is O(n). Therefore the entire
 * algorithm is T(n) = O(n) + O(n), which is simply T(n) = O(n).
 REFERENCES:
 ********************************************************************/ 
import java.util.Arrays;
/**
 *
 * @author carlos
 */
public class Problem2 {

    /**
     * Sorts a binary array in linear time.
     * @param array The binary array to be sorted.
     */
    public static void linearSort(int [] array)
    {
        int zeroCount = 0; // Used to keep track of the number of zeroes.
        
        // Iterate through the array and count the number zeroes.
        for(int item : array)
        {
            if(item == 0)
            {
                zeroCount++;
            }
            // If the item is not a 0 or a 1, the array is not binary.
            else if (item != 0 && item != 1)
            {
                System.out.println("The Array is not binary.");
                return;
            }
        }
        
        // Iterate through the array and override elements with 0's until
        // We have placed zeroCount 0's, then the rest are 1's.
        for(int i = 0; i < array.length; i++)
        {
            // Place a 0 if zeroCount is still > 0, otherwise place a 1.
            if(zeroCount > 0)
            {
                array[i] = 0;
                zeroCount--;
            }
            else
            {
                array[i] = 1;
            }
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] arrayToSort = {1,0,1,0,0,0,1,0,1,0,0,1};
        System.out.print("The original array is as follows: ");
        System.out.println(Arrays.toString(arrayToSort));
        
        linearSort(arrayToSort);
        
        System.out.print("The sorted array is as follows: ");
        System.out.println(Arrays.toString(arrayToSort));
        
        
    }
    
}
