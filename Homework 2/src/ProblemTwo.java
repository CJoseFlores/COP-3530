/*********************************************************************
 Purpose/Description: Implements two static functions that find the difference
 * and intersect, respectively, between lists L1 and L2.
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 * Explanation:
 * 2a) difference() - > Difference is implemented as O(N * M), where "N" is 
 * the size of "L1" and "M" is the size of "L2". The method iterates through
 * every L2 element for each L1 element, i.e. both lists are iterated in linear
 * time, but because L2 is called for each element of L1, then rather than O(N + M), 
 * the algorithm is O(N * M). NOTE: The collections method "BinarySearch()" was 
 * not used because the problem stated we could only use the iterators and 
 * compareTo(). Using "BinarySearch()" reduces the complexity to O(N * log M)
 * but only for Lists that implement "RandomAccess".
 * 2b) intersect() - > Intersect is implemented in the same way as difference()
 * except, where every element of L2 is iterated for every element of L1, therefore
 * once again O(N * M), and BinarySearch() was not used for the same reason.
 * Sources: https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#binarySearch(java.util.List,%20T)
 ********************************************************************/ 
import java.util.*;
/**
 *
 */
public class ProblemTwo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> listOne = new LinkedList();
        LinkedList<Integer> listTwo = new LinkedList();
        LinkedList<Integer> differenceList = new LinkedList();
        LinkedList<Integer> intersectList = new LinkedList();
        
        // Fill first list from 0 to 13
        for(int i=0; i < 14; i++)
        {
            listOne.add(i);
        }
        
        //<-----------Difference Test------------>
        
        // Fill second list with [2,5,7,8]
        listTwo.add(2);
        listTwo.add(5);
        listTwo.add(7);
        listTwo.add(8);
        
        System.out.println("L1: " + listOne);
        System.out.println("L2: " + listTwo);
        
        difference(listOne, listTwo, differenceList);
        
        System.out.println("L1 \\ L2: " + differenceList + "\n\n");
        
        //<-----------Intersect Test------------>
        listTwo.add(12);
        System.out.println("L1: " + listOne);
        System.out.println("L2: " + listTwo);
        intersection(listOne, listTwo, intersectList);
        System.out.println("L1 n L2 : " + intersectList);
        
    }
    
    /**
     * Calculates the difference between Lists, i.e. L1 \ L2
     * @param <AnyType> The data type stored in the lists.
     * @param L1 The first operand in the difference.
     * @param L2 The second operand in the difference.
     * @param Difference The difference between the lists, i.e. L1 \ L2
     */
    public static <AnyType extends Comparable<? super AnyType>>
        void difference(List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference)
    {
        // Used to hold the data from the iterator.
        AnyType itemL1;
        AnyType itemL2;
        
        // Flag used to check if an L1 item exists in L2.
        boolean existsInL2 = false;
        
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        if ( iterL1.hasNext() && iterL2.hasNext() )
        {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
            
            // YOUR CODE GOES HERE 
            while ( itemL1 != null ) {
                
                // Increment iterL1 if the L2 binary search was completed for
                // the current itemL1.
                if(!iterL2.hasNext() || existsInL2)
                {
                    // Add item to difference list if it doesn't exist in L2.
                    if(!existsInL2)
                    {
                        Difference.add(itemL1);
                    }
                    else
                    {
                        existsInL2 = false; // Set flag off.
                    }
                    
                    if(iterL1.hasNext())
                    {
                        // If not found in L2, add to the difference, go to next item in L1, 
                        // list, and reset iterL2 to head.
                        
                        itemL1 = iterL1.next();
                        iterL2 = L2.listIterator();
                    }
                    else
                    {
                        itemL1 = null;
                    }
                }
                // There are more elements in L2
                else
                {
                    itemL2 = iterL2.next();
                    if(itemL1.compareTo(itemL2) == 0)
                    {
                        existsInL2 = true;
                    }
                }
            }   
        }
    }
        

    /**
     * Calculates the intersection between lists, i.e. L1 ∩ L2 
     * @param <AnyType> The data type stored in the lists.
     * @param L1 The first operand in the intersection.
     * @param L2 The second operand in the intersection.
     * @param Intersect The intersection between lists, i.e. L1 ∩ L2 
     */
    public static <AnyType extends Comparable<? super AnyType>>
        void intersection(List<AnyType> L1, List<AnyType> L2, List<AnyType> Intersect)
    {
        //Used to hold the data from the iterators.
        AnyType itemL1;
        AnyType itemL2;
        
        boolean itemInBoth = false; // Flag to check if the item is in L1 and L2.
        
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        if ( iterL1.hasNext() && iterL2.hasNext() )
        {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
            
            // YOUR CODE GOES HERE 
            
            //Continue to iterate until every element of L1 has been compared
            //to L2.
            while(itemL1 != null)
            {
                // Add itemL1 if it is also in L2.
                if(itemL1.compareTo(itemL2) == 0)
                {
                    Intersect.add(itemL1);
                    itemInBoth = true;
                }
                // If there are more items in L2 and itemL1 & itemL2 have not been
                // found in both lists yet, iterate to next item in L2.
                if(iterL2.hasNext() && !itemInBoth)
                {
                    itemL2 = iterL2.next();
                }
                // Otherwise, move to the next item in L1, and reset to first
                // element in L2.
                else
                {
                    itemInBoth = false;
                    iterL2 = L2.listIterator();
                    if(iterL1.hasNext())
                    {
                        itemL1 = iterL1.next();
                    }
                    else
                    {
                        // If no more items in L1, point itemL1 to null and end
                        // the loop.
                        itemL1 = null;
                    }
                }

            }
        }    
    }
}
