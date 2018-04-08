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
 * Extracting the number of digits from an int in O(1) using Math.log10()
 * http://www.baeldung.com/java-number-of-digits-in-int 
 ********************************************************************/ 
import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author carlos
 */
public class Problem2 {

    /**
     * Sorts a binary array in linear time. (Problem 2A)
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
    
    public static void specialRadixSort(int [] array)
    {
        ArrayList<Integer>[] buckets = new ArrayList[10]; // Holds the buckets.
        int digit; // Holds the number of digits in the array element.
        int binIndex; // The value of the bin that the element should go to.
        int truncVal; // The value of the element truncated by "digitPlace".
        
        int digitPlace = 1; // The current place of the digit.
        int maxDigit = 0; // Holds the max number of digits in the array.
        int numPasses = 0; // Number of passes
        
        // Insert the buckets to hold items when making the bucket sort passes.
        for(int i = 0; i < 10; i++)
        {
            buckets[i] = new ArrayList();
        }
        
        // Iterating through the array to find the maximum amount of digits.
        for(int item : array)
        {
            // Extract the amount of digits for the item.
            digit = (int) (Math.log10(item) + 1);
            
            if(digit > maxDigit)
            {
                maxDigit = digit;
            }
        }
        
        System.out.println("Max digit in array: " + maxDigit);
        
        while(numPasses < maxDigit)
        {
            // Make a pass through the array looking at the current digitPlace.
            for(int item : array)
            {
                truncVal = item / digitPlace;
                binIndex = truncVal % 10;
                
                // If extracted number is odd, subtract by 1 to make it even,
                // And insert the original "item" number by digitPlace to scale
                // it.
                if(binIndex % 2 != 0)
                {
                    binIndex--;
                    buckets[binIndex].add(item - digitPlace);
                    
                }
                else
                {
                    buckets[binIndex].add(item);
                }   
            }
            
            int arrayIndex = 0; // Used to iterate through array.
            
            // Iterate through buckets and place them back into original array.
            for(int i=0; i < buckets.length; i++)
            {
                for(int j = 0; j < buckets[i].size(); j++)
                {
                    array[arrayIndex++] = buckets[i].get(j);
                }
                
                // Clear that bucket of items to get it ready for next pass.
                buckets[i].clear();
            }
            
            // Move to the next digit place and make another pass if needed.
            digitPlace = digitPlace * 10; 
            numPasses++;
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
        
        
        System.out.println("\nPROBLEM 2B:");
        int [] otherArrayToSort = {13, 4680, 24062, 51, 86, 642, 51, 426, 888};
        System.out.print("The input array is as follows: ");
        System.out.println(Arrays.toString(otherArrayToSort));
        
        specialRadixSort(otherArrayToSort);
        System.out.print("The sorted array is as follows: ");
        System.out.println(Arrays.toString(otherArrayToSort));
        
        
        
        
        
        
    }
    
}
