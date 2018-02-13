/*********************************************************************
 Purpose/Description: Searches an array by dividing the array by 3, and recursively
 * calling itself to search one of the three sectors until element is found or
 * it is determined the element does not exist in the array.
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 * Question (B):
 * The time complexity of the method "terSearch()" is O(log N). On every 
 * recursive call, the input size (array) is divided by 3 by shifting either
 * "l" or "r" or both to one of the sectors defined by "d1" and "d2". Using the
 * logarithmic rule, then the complexity is log3(N), which is simply O(log N).
 ********************************************************************/ 

public class ProblemOne {

    private static int terSearch(int arr[], int l, int r, int x)
    {
        // Two pivot points used to divide array in three sectors.
        int d1 = l + (r-l)/3;
        int d2 = d1 + (r-l)/3;

        // If l > r, then the term was not found in the array.
        if(l > r)
        {
            return -1;
        }
        // if arr[d1] == x, we found the element, return the index "d1".
        else if(arr[d1] == x)
        {
            return d1;
        }
        // if arr[d2] == x, we found the element, return the index "d2".
        else if(arr[d2] == x)
        {
            return d2;
        }
        // if arr[d1] > x, x must be in the first sector, move r to "d1 - 1".
        else if(arr[d1] > x)
        {
            return terSearch(arr, l, d1 - 1, x);
        }
        // if arr[d2] < x, x must be in the last sector, move l to "d2 + 1".
        else if(arr[d2] < x)
        {
            return terSearch(arr, d2 + 1, r, x);
        }
        // Otherwise, x must be in the middle circle, move l & r to d1 & d2 
        // respectively.
        else
        {
            return terSearch(arr, d1, d2, x);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int searchResult; // Holds result of the search.
        int searchTermOne = 15; // Test to see if returns proper index.
        int searchTermTwo = 22; // Test to see if returns -1.
        
        System.out.print("Given Array: [");
        for(int i: a)
        {
            System.out.print(i + " ");
        }
        System.out.println("]");
        
        // Testing if number can be properly found.
        searchResult = terSearch(a, 0, a.length - 1, searchTermOne);
        if(searchResult == -1)
        {
            System.out.println("Sorry! \"" + searchTermOne + "\" was not found!");
        }
        else
        {
            System.out.println("Nice! \"" + searchTermOne + "\" was found at index: "
                    + searchResult);
        }
        
        //Testing if term is not found.
        searchResult = terSearch(a, 0, a.length - 1, searchTermTwo);
        if(searchResult == -1)
        {
            System.out.println("Sorry! \"" + searchTermTwo + "\" was not found!");
        }
        else
        {
            System.out.println("Nice! \"" + searchTermTwo + "\" was found at index: "
                    + searchResult);
        }
        
    }
    
}
