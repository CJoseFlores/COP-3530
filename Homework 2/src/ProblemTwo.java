/*********************************************************************
 Purpose/Description: <a brief description of the program>
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
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
        
        // Fill first list from 0 to 13
        for(int i=0; i < 14; i++)
        {
            listOne.add(i);
        }
        
        // Fill second list with [2,5,7,8]
        listTwo.add(2);
        listTwo.add(5);
        listTwo.add(7);
        listTwo.add(8);
        
        System.out.println("L1: " + listOne);
        System.out.println("L2: " + listTwo);
        
        difference(listOne, listTwo, differenceList);
        
        System.out.println("L1 \\ L2: " + differenceList);
        
        System.out.println("\n\n");
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
        
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        if ( iterL1.hasNext() && iterL2.hasNext() )
        {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        // YOUR CODE GOES HERE 
    }
    
}
