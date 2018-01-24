/*******************************************************************************
 * Purpose/Description: A program that recursively finds the "nth" number in
 * the fibonacci sequence F(n), with time complexity O(log n)
 * Author's Panther ID: 5160328
 * Certification:
    I hereby certify that this work is my own and none of it is the work of any
    other person.
 * QUESTION (b): The algorithm implemented is of complexity O(log n)
 * The method that actually implements the algorithm is "the BigInteger()" method.
 * Following the link from the references, two formulas were derived from
 * matrix exponentiation, one for even "n" and one for odd "n"
 * For even n: F(2n) = (2F(n-1) + F(n))* F(n)
 * For odd n: F(2n - 1) = F(n)^2 + F(n-1) ^2
 * Looking at these equations, we note that we are not getting F(n), so we simply
 * plug in "n/2" for "n" in the even equation, and "(n+1)/2" for "n" in the odd
 * equation, which results in the following new equations:
 * For even n: F(n) = (2F((n/2) -1) + F(n/2)) * F(n/2)
 * For odd n: F(n) = F((n+1)/2)^2 + F(((n+1)/2) - 1)^2
 * We can see that for every iteration, we are dividing the size by two.
 * I.e., for every recursive method call, we are reducing the size by two,
 * which according to the logarithm general rule, since we are halving the input
 * size on every recursive call, we end up with complexity O(log n). There are also
 * two trivial cases when n is 1 or 2, f(n) = 1, and when n is 0, f(n) = 0, which
 * both simply use constant complexity of O(1) since it does not depend on the size.
 * Therefore, the time complexity of the algorithm I implemented is O(log n).
 * References: http://www.cs.utexas.edu/users/EWD/ewd06xx/EWD654.PDF
 * This reference was used to implement the fibonacci number sequence in sub-linear time.
*******************************************************************************/
import java.math.BigInteger;

public class ProblemThree {

    // <--------------------------------------------------------------->
    // <-------THIS IS THE METHOD THAT IMPLEMENTS THE ALGORITHM!------->
    // <--------------------------------------------------------------->
    // Generates the fibonacci number through formulas derived from 
    //exponentiation by matricies.
    private static BigInteger fib(int n)
    {
        BigInteger ans; // Retains the value fib(n)

        // Trivial case of fib(2) == fib(1) == 0
        if(n == 2 || n == 1)
        {
            ans = BigInteger.valueOf(1);
        }
        // Trivial case of fib(0) = 0
        else if(n == 0)
        {
            ans = BigInteger.valueOf(0);
        }
        //Use the f(2n) formula for even values.
        else if(n % 2 == 0)
        {
            //The equation for even size is F(2n) = (2F(n-1) + F(n))* Fn
            //We can therefore reduce the size by 2 on each iteration by plugging
            //in "n/2" for n, thereby deriving F(n)
            //i.e. F(n) = (2F((n/2) -1) + F(n/2)) * F(n/2)
            ans = fib((n/2) - 1).multiply(BigInteger.valueOf(2))
                    .add(fib(n/2)).multiply(fib(n/2));
        }
        //Use the f(2n - 1) formula for odd values.
        else
        {
            //The same f(n) can be derived for odd values.
            //Original Equation for Odd size: F(2n - 1) = F(n)^2 + F(n-1) ^2
            //Here, we can plug in (n+1)/2 for "n" to get F(n)
            //i.e. F(n) = F((n+1)/2)^2 + F(((n+1)/2) - 1)^2
            ans = fib((n+1)/2).pow(2).add(fib(((n+1)/2) - 1).pow(2));
        }
        
        return ans;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Print out fibNum(0) through fibNum(10)
        for(int i=0; i <= 10; i++)
        {
            System.out.println("fibNum(" + i + ") = " + fib(i));
        }
        
        System.out.println(fib(250));
    }
    
}
