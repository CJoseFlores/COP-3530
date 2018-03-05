/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos
 */
public class SelectionSortTester {

    private static int [] selectionSort(int [] a)
    {
        
        int holdIndex; // Used to hold the index for the current min.
        int tmp; // Used to hold a temporary value.
        
        // Outer loop moves the wall for the sorted area portion.
        // "-1" prevents you from checking the last element, it's already sorted.
        for(int i=0; i < a.length - 1; i++)
        {
            holdIndex = i; // By default holds the value next to the wall.
            
            for(int j = i + 1; j < a.length; j++)
            {
                // Update the index for the minimum value if the current element
                // is less than the element pointed by the holdIndex.
                if(a[j] < a[holdIndex])
                {
                    holdIndex = j;
                }
            }
            
            // Swap the element next to the wall with the minimum in the unsorted
            // portion.
            tmp = a[holdIndex];
            a[holdIndex] = a[i];
            a[i] = tmp;
        }
        
        
        
        return a; // Hold the value to 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] a = new int [4];   
        
        a[0] = 4;
        a[1] = 3;
        a[2] = 2;
        a[3] = 1;
        System.out.println("The original array: ");
        for(int i=0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
        
        System.out.println("The sorted array after selection sort: ");
        a = selectionSort(a);
        for(int i=0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
        
    }
    
}
