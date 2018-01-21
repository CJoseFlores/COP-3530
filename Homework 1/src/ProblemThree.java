/*******************************************************************************
 * Purpose/Description: PLEASE FILL
 * Author's Panther ID: 5160328
 * Certification:
    I hereby certify that this work is my own and none of it is the work of any
    other person.
 * QUESTION (b): The algorithm implemented is of complexity O(log n)
 * The first if statement simply has a return statement, so it has constant 
 * time complexity.
 * The while loop contains an if statement with constant time complexity, 
 * and a counter that is halved on every iteration.
 * Since everything inside the while loop has constant time complexity, then
 * the while loop's complexity only depends on how the amount of iterations depends
 * on the input size.
 * Lets assume that "k" is the amount of iterations, and "n-1" is the input size
 * (since i = n-1 in the beginning, but lets assume the input size is "n" for simplicity).
 * Looking at the while loop, the counter "i" is halved on every iteration, so
 * lets observe the number of iterations if n >= 2 and is a power of 2.
 * Example: n = 8 = 2^3
 * First iteration, i = 8, second iteration i = 4, third iteration i = 2, fourth iteration = 1
 * And then finally when the fourth iteration is over, i = 0 so the while loop ends.
 * We can see that for 2^3, there are 4 iterations.
 * We can then see that the relationship for "k" iterations with input size "n"
 * is simply n = 2^(k-1) when n >= 2 that is a power of 2. To actually get the number of iterations,
 * we solve for "k" and get k = (log n) + 1. 
 * Note that for n >= 2 that is a power of 2, this equation also applies, except
 * the log is floored, i.e. k = floor(log n) + 1.
 * Ex: n = 9, then the loop runs k = floor(log 9) + 1 = floor(3.16) + 1 
 * = 3 + 1 = 4 times.
 * So we now know that T(n) is roughly floor(log n) + 1, which translates to
 * O(log n). (not that although T(n) is only valid for n >= 2, time complexity
 * is only concerned with n -> infinity, so this is still fine).
 * References: https://en.wikibooks.org/wiki/Algorithm_Implementation/Mathematics/Fibonacci_Number_Program
 * This reference was used to implement the fibonacci number sequence in sub-linear time.
*******************************************************************************/
public class ProblemThree {

    // <--------------------------------------------------------------->
    // <-------THIS IS THE METHOD THAT IMPLEMENTS THE ALGORITHM!------->
    // <--------------------------------------------------------------->
    // Generates the fibonacci number through exponentiation by squaring.
    private static double fibNum(int n)
    {
        // Variables used to exponentiate the numbers, and generate the fib number.
        double i = n - 1, a = 1, b = 0, c = 0, d = 1, t;
        
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
            i = Math.floor(i); //Truncate decimal places to simulate int division.
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
        
        System.out.println(fibNum(250));
    }
    
}
