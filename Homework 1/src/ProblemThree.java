/*******************************************************************************
 * Purpose/Description: PLEASE FILL
 * Author's Panther ID: 5160328
 * Certification:
    I hereby certify that this work is my own and none of it is the work of any
    other person.
 * QUESTION (b): PLEASE FILL
 * References: https://en.wikibooks.org/wiki/Algorithm_Implementation/Mathematics/Fibonacci_Number_Program
 * This reference was used to implement the fibonacci number sequence in sub-linear time.
*******************************************************************************/
public class ProblemThree {

    // <--------------------------------------------------------------->
    // <-------THIS IS THE METHOD THAT IMPLEMENTS THE ALGORITHM!------->
    // <--------------------------------------------------------------->
    // Generates the fibonacci number through exponentiation by squaring.
    private static long fibNum(int n)
    {
        // Variables used to exponentiate the numbers, and generate the fib number.
        long i = n - 1, a = 1, b = 0, c = 0, d = 1, t;
        
        //fibNum(0) is simply 0. Also return 0 for negative numbers.
        if(n <= 0 )
        {
            return 0;
        }
        
        while(i > 0)
        {
            if (i % 2 == 1)
            {
                t = d*(b + a) + c*b;
                a = d*b + c*a;
                b = t;
            }
            t = d*(2*c + d);
            c = c*c + d*d;
            d = t;
            i = i / 2;
        }
        return a + b;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Print out fibNum(0) through fibNum(10)
        for(int i=0; i <= 10; i++)
        {
            System.out.println("fibNum(" + i + ") = " + fibNum(i));
        }
        
        System.out.println(fibNum(50));
    }
    
}
