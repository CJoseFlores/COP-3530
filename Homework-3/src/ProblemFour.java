/*********************************************************************
 Purpose/Description: Searches a previously sorted array who has been rotated
                      an unknown number of times.
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 * Questions:
 * PART (A):
 * The actual algorithm is implemented in the "pivotedSearch()" method.
 * PART (B):
 * The implemented algorithm is O(log n), explanation:
 * 
 * The first thing pivotedSearch() does is call the recursive private method
 * "pivotIndex()" which attempts to find the pivot point of a possibly rotated
 * array. Because it is a recursive method, it requires some base cases. The 
 * first base case is that low index of the array is > the high index, which 
 * means that we have iterated through the whole array and did not find a pivot
 * so it returns "-1" since no pivot was found. Another base case is that the 
 * low index == high index, meaning that the pivot is exactly the low/high value.
 * We then check if the pivot is either the element to the left of the mid, or
 * the mid itself. Otherwise, we need to check either the left or right
 * portion of the array (from the mid) for the pivot. On every recursive call
 * to check either the left or right portion, the size of the array is divided
 * by 2, so in the end the complexity of pivotIndex() is O(log n).
 * 
 * After the pivotIndex() method has been executed, we perform binarySearches
 * on different portions of the array (from the pivot). If pivotIndex() did not
 * find the pivot, then the array is still pre-sorted, so perform a simple
 * binary search (which is O(log n)). Otherwise, ONLY perform a binary search
 * on either the right or left side of the array. Either way, we perform
 * binary search on the array, which is simply O(log n).
 * 
 * Therefore the complexity of pivotedSearch(), T(n) = O(log n) + O(log n) = O(log n)
 * where the first "O(log n)" is pivotIndex() and the second "O(log n)" is 
 * a binary search.
 * 
 * i.e. the complexity of pivotedSearch() is O(log n).
 ********************************************************************/ 
import java.util.Arrays;

public class ProblemFour {

    // Used as a simple driver class.
    public class PivotSearch
    {
        /**
         * Searches an previously sorted array who has been rotated an unknown
         * number of times.
         * @param array The array to search for a value.
         * @param val The value to search for.
         * @return The index of the value. Returns -1 if not found.
         */
        public int pivotedSearch(int array[], int val)
        {
            int pivotPoint = pivotIndex(array, 0, array.length - 1);
            
            // If there is no pivot point, array is perfectly sorted, perform
            // a simple binary search.
            if (pivotPoint == -1)
            {
                return binarySearch(array, val, 0, array.length - 1);
            }
            // If the element at the pivot point is the val, return pivot's index.
            else if (array[pivotPoint] == val)
            {
                return pivotPoint;
            }
            // If the first element in the left side of the array is less than
            // or equal to the value, then we know it might be in the left side of
            // the array (from the pivot).
            else if(array[0] <= val)
            {
                return binarySearch(array, val, 0, pivotPoint - 1);
            }
            // Otherwise, it may be on the right side of the array.
            else
            {
                return binarySearch(array, val, pivotPoint + 1, array.length - 1);
            }
        }
        
        // Finds the index for the pivot (if was rotated at all).
        private int pivotIndex(int array[], int low, int high)
        {
            int mid; // Used to keep track of the mid index.

            // If low > high, then no pivot was found, array is already sorted.
            if(low > high)
            {
                return -1;
            }
            // Otherwise if low == high, then the pivot is the current element.
            else if(low == high)
            {
                return low; 
            }
            
            mid = (low + high) / 2;
            
            // If the mid is not the last element, but is larger than the next,
            // Then it must be the pivot.
            if(mid < high && array[mid] > array[mid + 1])
            {
                return mid; 
            }
            // If the mid is not the first element, but is less than the previous,
            // Then it must be the pivot.
            else if(mid > low && array[mid] < array[mid - 1])
            {
                return mid-1;
            }
            // If the pivot was not found yet, but the lowest element is larger
            // Than the mid, then the pivot may or may not be in the lower half
            // of the array.
            else if(array[low] >= array[mid])
            {
                return pivotIndex(array, low, mid-1);
            }
            // Otherwise the pivot may or may not be in the upper half of the array.
            else
            {
                return pivotIndex(array, mid + 1, high);
            }
        }
        
        // Performs binary search on an array to find a value.
        private int binarySearch(int array[], int val, int low_val, int high_val)
        {
            int low = low_val;
            int high = high_val;
            int mid;
            
            while(high >= low)
            {
                mid = (low + high) / 2;
                
                // If the mid is the value, we found the index.
                if(array[mid] == val)   
                {
                    return mid;
                }
                // If the value is smaller than the mid, it has to be on the left side of the array.
                if(array[mid] < val)
                {
                    low = mid + 1;
                }
                // If the value is larger than the mid, it has to be on the right side of the array.
                if(array[mid] > val)
                {
                    high = mid - 1;
                }
            }
            
            return -1; // Element was not found.
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProblemFour.PivotSearch pSearch = new ProblemFour().new PivotSearch();
        
        // Sample array that has been rotated, previous pre-sorted.
        int [] sampleArray = {15,16,19,20,25,1,3,4,5,7,10,14};

        System.out.println("The following is the given rotated array: ");
        System.out.println(Arrays.toString(sampleArray));
        System.out.print("\nThe index for the number \"1\" is : ");
        System.out.println(pSearch.pivotedSearch(sampleArray, 1));
        System.out.print("\nThe index for the number \"20\" is: ");
        System.out.println(pSearch.pivotedSearch(sampleArray, 20));
    }
    
}
