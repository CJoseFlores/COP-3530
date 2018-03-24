/*********************************************************************
 Purpose/Description: IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 * Questions:
 
 REFERENCES:
 * Note, the code for min/max heap implementation was taken from the following
 * links (since it is assumed we have them available):
 * http://users.cis.fiu.edu/~weiss/cop3530_sum08/July16.java
 * https://users.cs.fiu.edu/~weiss/dsj4/code/weiss/nonstandard/UnderflowException.java
 * The code was modified to work with the problem.
 ********************************************************************/ 

import java.util.Comparator;
import java.util.Arrays;

public class ProblemOne {
    
    /**
     * Exception class for access in empty containers
     * such as stacks, queues, and priority queues.
     * @author Mark Allen Weiss
     */
    public class UnderflowException extends RuntimeException
    {
        /**
         * Construct this exception object.
         * @param message the error message.
         */
        public UnderflowException( String message )
        {
            super( message );
        }
    }
    
    public class MinHeap<AnyType>
    {
        public MinHeap( )
        {
            this( DEFAULT_CAPACITY );
        }

        public MinHeap( int capacity )
        {
            this( null, capacity );
        }

        public MinHeap( Comparator<? super AnyType> c )
        {
            this( c, DEFAULT_CAPACITY );
        }

        public MinHeap( Comparator<? super AnyType> c, int capacity )
        {
            currentSize = 0;
            heap = (AnyType[]) new Comparable[ capacity + 1 ];
            cmp = c;
        }

        public MinHeap( AnyType [ ] items )
        {
            this( items, null );
        }

        public MinHeap( AnyType [ ] items, Comparator<? super AnyType> c )
        {
            cmp = c;
            currentSize = items.length;
            heap = (AnyType[]) new Object[ ( currentSize + 2 ) * 11 / 10 ];

            int i = 1;
            for( AnyType item : items )
                heap[ i++ ] = item;
            buildHeap( );
        }

        private int myCompare( AnyType lhs, AnyType rhs )
        {
            if( cmp != null )
                return cmp.compare( lhs, rhs );
            else
                return ((Comparable)lhs).compareTo( rhs );
        }


        public void insert( AnyType x )
        {
            if( currentSize == heap.length - 1 )
                enlargeArray( heap.length * 2 + 1 );

            // Percolate up
            percolateUp(x);
        }


        private void enlargeArray( int newSize )
        {
            AnyType [] old = heap;
            heap = (AnyType []) new Object[ newSize ];
            for( int i = 0; i < old.length; i++ )
                heap[ i ] = old[ i ];        
        }

        public AnyType findMin( )
        {
            if( isEmpty( ) )
                throw new UnderflowException("Test String to Compile.");
            return heap[ 1 ];
        }

        public AnyType deleteMin( )
        {
            if( isEmpty( ) )
                throw new UnderflowException("Test String to Compile.");

            AnyType minItem = findMin( );
            
            heap[ 1 ] = heap[ currentSize];
            heap[currentSize] = null;
            currentSize--;
            
            percolateDown( 1 );

            return minItem;
        }

        private void buildHeap( )
        {
            for( int i = currentSize / 2; i > 0; i-- )
                percolateDown( i );
        }

        public boolean isEmpty( )
        {
            return currentSize == 0;
        }

        public void makeEmpty( )
        {
            currentSize = 0;
        }

        private static final int DEFAULT_CAPACITY = 10;

        private int currentSize;      // Number of elements in heap
        private AnyType [ ] heap; // The heap array
        private Comparator<? super AnyType> cmp;

        private void percolateDown( int hole )
        {
            int child;
            AnyType tmp = heap[ hole ];

            for( ; hole * 2 <= currentSize; hole = child )
            {
                child = hole * 2;
                if( child != currentSize &&
                        myCompare(heap[ child + 1 ], heap[ child ] ) < 0 )
                    child++;
                if( myCompare(heap[ child ], tmp ) < 0 )
                    heap[ hole ] = heap[ child ];
                else
                    break;
            }
            heap[ hole ] = tmp;
        }
        
        
        private void percolateUp( AnyType x)
        {
            int hole = ++currentSize;
            for( ; hole > 1 && myCompare(x, heap[ hole / 2 ] ) < 0; hole /= 2 )
                heap[ hole ] = heap[ hole / 2 ];
            heap[ hole ] = x;
        }
        
        
        @Override
        public String toString()
        {
            return Arrays.toString(heap);
        }
        
    }
    
    public class MaxHeap<AnyType>
    {
        public MaxHeap( )
        {
            this( DEFAULT_CAPACITY );
        }

        public MaxHeap( int capacity )
        {
            this( null, capacity );
        }

        public MaxHeap( Comparator<? super AnyType> c )
        {
            this( c, DEFAULT_CAPACITY );
        }

        public MaxHeap( Comparator<? super AnyType> c, int capacity )
        {
            currentSize = 0;
            heap = (AnyType[]) new Comparable[ capacity + 1 ];
            cmp = c;
        }

        public MaxHeap( AnyType [ ] items )
        {
            this( items, null );
        }

        public MaxHeap( AnyType [ ] items, Comparator<? super AnyType> c )
        {
            cmp = c;
            currentSize = items.length;
            heap = (AnyType[]) new Object[ ( currentSize + 2 ) * 11 / 10 ];

            int i = 1;
            for( AnyType item : items )
                heap[ i++ ] = item;
            buildHeap( );
        }

        private int myCompare( AnyType lhs, AnyType rhs )
        {
            if( cmp != null )
                return cmp.compare( lhs, rhs );
            else
                return ((Comparable)lhs).compareTo( rhs );
        }


        public void insert( AnyType x )
        {
            if( currentSize == heap.length - 1 )
                enlargeArray( heap.length * 2 + 1 );
            
            currentSize++;
            
            // Percolate up
            percolateUp(x, currentSize);
        }


        private void enlargeArray( int newSize )
        {
            AnyType [] old = heap;
            heap = (AnyType []) new Object[ newSize ];
            for( int i = 0; i < old.length; i++ )
                heap[ i ] = old[ i ];        
        }

        public AnyType findMin( )
        {
            if( isEmpty( ) )
                throw new UnderflowException("Test String to Compile.");
            return heap[ 1 ];
        }

        public AnyType deleteMax( )
        {
            if( isEmpty( ) )
                throw new UnderflowException("Test String to Compile.");

            AnyType minItem = findMin( );
            heap[ 1 ] = heap[currentSize];
            heap[currentSize] = null;
            currentSize--;
            
            percolateDown( 1 );

            return minItem;
        }

        private void buildHeap( )
        {
            for( int i = currentSize / 2; i > 0; i-- )
                percolateDown( i );
        }

        public boolean isEmpty( )
        {
            return currentSize == 0;
        }

        public void makeEmpty( )
        {
            currentSize = 0;
        }

        private static final int DEFAULT_CAPACITY = 10;

        private int currentSize;      // Number of elements in heap
        private AnyType [ ] heap; // The heap array
        private Comparator<? super AnyType> cmp;

        private void percolateDown( int hole )
        {
            int child;
            AnyType tmp = heap[ hole ];

            for( ; hole * 2 <= currentSize; hole = child )
            {
                child = hole * 2;
                if( child != currentSize &&
                        myCompare(heap[ child + 1 ], heap[ child ] ) > 0 )
                    child++;
                if( myCompare(heap[ child ], tmp ) > 0 )
                    heap[ hole ] = heap[ child ];
                else
                    break;
            }
            heap[ hole ] = tmp;
        }
        
        //Who did this!?!? 😂👌
        private void percolateUp( AnyType x, int currentIndex)
        {
            int hole = currentIndex;
            for( ; hole > 1 && myCompare(x, heap[ hole / 2 ] ) > 0; hole /= 2 )
                heap[ hole ] = heap[ hole / 2 ];
            heap[ hole ] = x;
        }
        
        
        @Override
        public String toString()
        {
            return Arrays.toString(heap);
        }
        
        /***************************************************** 
        * THE CODE BELOW IS USED TO ANSWER PROBLEM 1, PART (C)
        ***************************************************** 
        */
        
        /**
         * Replace an "oldKey" with a "newKey" if found, otherwise print error.
         * @param oldKey The key to replace.
         * @param newKey The key to replace with.
         */
        public void replaceKey(AnyType oldKey, AnyType newKey)
        {
            // Iterate through the used portion of the heap array, and replace
            // oldKey with newKey if found, otherwise print response.
            for(int i = 1; i < currentSize + 1; i++)
            {
                if(heap[i].equals(oldKey))
                {
                    heap[i] = newKey; // Replacing the oldKey.
                    
                    // Attempt to percolateUp if needed, otherwise it will 
                    // exit on first attempt.
                    percolateUp(newKey, i);
                    
                    // Attempt to percolateDown if needed, otherwise it will
                    // exit on first attempt.
                    percolateDown(i);
                    
                    return;
                }
            }
            
            System.out.println("The specified key is not in the heap.");
        }
        
    }

    // Test program
    public static void main( String [ ] args )
    {
        //ProblemOne.MinHeap<Integer> minHeapTest = new ProblemOne().new MinHeap<Integer>( );
        ProblemOne.MaxHeap<Integer> maxHeapTest = new ProblemOne().new MaxHeap<Integer>( );
        
//        //Inserting heap from board.
//        minHeapTest.insert(10);
//        minHeapTest.insert(20);
//        minHeapTest.insert(30);
//        minHeapTest.insert(21);
//        minHeapTest.insert(22);
//        System.out.println("Min Heap: ");
//        System.out.println(minHeapTest);
//        System.out.println("Inserting 6...");
//        minHeapTest.insert(6);
//        System.out.println(minHeapTest);
//        System.out.println("Deleting Min..");
//        minHeapTest.deleteMin();
//        System.out.println(minHeapTest);
        
        
        
        
        
        /***************************************************** 
        * THE CODE BELOW IS USED TO ANSWER PROBLEM 1, PART (C)
        ***************************************************** 
        */
        maxHeapTest.insert(99);
        maxHeapTest.insert(64);
        maxHeapTest.insert(42);
        maxHeapTest.insert(54);
        maxHeapTest.insert(32);
        maxHeapTest.insert(28);
        maxHeapTest.insert(6);
        maxHeapTest.insert(19);
        maxHeapTest.insert(7);
        maxHeapTest.insert(26);
        maxHeapTest.insert(4);
        System.out.println("--------------------------------------");
        System.out.println("Problem 1, Part (C):");
        System.out.println("--------------------------------------");
        System.out.print("The following is the given heap: ");
        System.out.println(maxHeapTest);
        System.out.println("Attempting to replace 54 with 105....");
        maxHeapTest.replaceKey(new Integer(54), new Integer(105));
        System.out.println("Resulting Heap: ");
        System.out.println(maxHeapTest);
        System.out.println("\nAttempting to replace 100 with 200....");
        maxHeapTest.replaceKey(new Integer(100), new Integer(200));
        System.out.println("Resulting Heap: ");
        System.out.println(maxHeapTest);
        
        
        
        
        System.out.println("\nWho did this!?!? 😂👌");
        
       
    }

    
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        ProblemOne.MinHeap minHeapTest = new ProblemOne().new MinHeap(10);
//        ProblemOne.MaxHeap maxHeapTest = new ProblemOne().new MaxHeap(10);
//        
//        
//        // Inserting heap from board.
//        minHeapTest.insert(10);
//        minHeapTest.insert(20);
//        minHeapTest.insert(30);
//        minHeapTest.insert(21);
//        minHeapTest.insert(22);
//        System.out.println("Min Heap: ");
//        System.out.println(minHeapTest);
//        
//        System.out.println("Inserting 6...");
//        minHeapTest.insert(6);
//        System.out.println(minHeapTest);
//        System.out.println("Deleting min...");
//        minHeapTest.delMin();
//        System.out.println(minHeapTest);
//        System.out.println("");
//        
//        System.out.println("MaxHeap: ");
//        maxHeapTest.insert(10);
//        maxHeapTest.insert(20);
//        maxHeapTest.insert(30);
//        maxHeapTest.insert(21);
//        maxHeapTest.insert(22);
//        System.out.println(maxHeapTest);
//        
//        System.out.println("Inserting 6...");
//        maxHeapTest.insert(6);
//        System.out.println(maxHeapTest);
//        System.out.println("Deleting max...");
//        maxHeapTest.delMax();
//        System.out.println(maxHeapTest);
//        System.out.println("");
//        
//        
//    }
    
}
