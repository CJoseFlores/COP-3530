/*********************************************************************
 Purpose/Description: Implements two static functions that find the difference
 * and intersect, respectively, between lists L1 and L2.
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 * Explanation:
 * 2a) difference() - > 
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
        for(int i=0; i < 7; i++)
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
        
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        
        if ( iterL1.hasNext() && iterL2.hasNext() )
        {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
            
            // YOUR CODE GOES HERE 
            // Continue to iterate as long as 
            while (iterL1.hasNext()) {
                // If there are still items in L1, but not L2, then all the items
                // left in L1 should be in the difference.
                if(!iterL2.hasNext())
                {
                    // Only add item to difference if not equal to last L2 item.
                    if(itemL1.compareTo(itemL2) != 0)
                    {
                        Difference.add(itemL1);
                    }
                    itemL1 = iterL1.next();
                }
                // If itemL1 < itemL2, then itemL1 is not in L2, so add to the 
                // difference, and increment only L1.
                else if(itemL1.compareTo(itemL2) < 0)
                {
                    Difference.add(itemL1);
                    itemL1 = iterL1.next();
                }
                // If itemL1 > itemL2, then simply iterate L2 and don't add it
                // to the difference.
                else if (itemL1.compareTo(itemL2) > 0)
                {
                    itemL2 = iterL2.next();
                }
                // Otherwise the item is in both L1 & L2, so do not add it to the
                // difference, only 
                else
                {
                    itemL1 = iterL1.next();
                    itemL2 = iterL2.next();
                }
            }
            
            // Add the last element in L1 
            Difference.add(itemL1);
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
            while(iterL1.hasNext())
            {
                if(!iterL2.hasNext())
                {
                    // Check if last item on L2 is equal to current in L1.
                    if(itemL1.compareTo(itemL2) == 0)
                    {
                        Intersect.add(itemL1);
                    }
                    itemL1 = iterL1.next();
                }
                // If both items are equal, iterate to next item and add to 
                // intersect.
                else if(itemL1.compareTo(itemL2) == 0)
                {
                    Intersect.add(itemL1);
                    itemL1 = iterL1.next();
                    itemL2 = iterL2.next();
                }
                // If itemL1 < itemL2, then simply iterate L1.
                else if(itemL1.compareTo(itemL2) < 0)
                {
                    itemL1 = iterL1.next();
                }
                // If itemL1 > itemL2, then iterate L2.
                else if (itemL1.compareTo(itemL2) > 0)
                {
                    itemL2 = iterL2.next();
                }

            }
            
            // Check if last element in L1 is equal to last element in L2, then
            //add to intersection.
            if (itemL1.compareTo(itemL2) == 0)
            {
                Intersect.add(itemL1);
            }
                
        }    
    }
}
