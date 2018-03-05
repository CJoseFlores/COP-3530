/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertionSort;



/**
 *
 * @author carlos
 */
public class InsertionSortTester {

    private static int [] insertionSort(int [] a)
    {
        int tmp; // Used to hold a value for swapping.
        
        // Used to iterate to the next element.
        for(int i=1; i < a.length; i++)
        {
            // Check element before and continously swap.
            for(int j=i; j >= 1; j--)
            {
                // Swap if current element less than previous, otherwise break.
                if(a[j] < a[j-1])
                {
                    tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
                else
                {
                    break;
                }
            }
        }
        
        return a;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
        
        System.out.println("The sorted array after insertion sort: ");
        a = insertionSort(a);
        for(int i=0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
    
}
