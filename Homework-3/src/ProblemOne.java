/*********************************************************************
 Purpose/Description: IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
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
        private void percolateUp( AnyType x)
        {
            int hole = ++currentSize;
            for( ; hole > 1 && myCompare(x, heap[ hole / 2 ] ) > 0; hole /= 2 )
                heap[ hole ] = heap[ hole / 2 ];
            heap[ hole ] = x;
        }
        
        
        @Override
        public String toString()
        {
            return Arrays.toString(heap);
        }
        
    }

    // Test program
    public static void main( String [ ] args )
    {
        ProblemOne.MinHeap<Integer> minHeapTest = new ProblemOne().new MinHeap<Integer>( );
        ProblemOne.MaxHeap<Integer> maxHeapTest = new ProblemOne().new MaxHeap<Integer>( );
        
        //Inserting heap from board.
        minHeapTest.insert(10);
        minHeapTest.insert(20);
        minHeapTest.insert(30);
        minHeapTest.insert(21);
        minHeapTest.insert(22);
        System.out.println("Min Heap: ");
        System.out.println(minHeapTest);
        System.out.println("Inserting 6...");
        minHeapTest.insert(6);
        System.out.println(minHeapTest);
        System.out.println("Deleting Min..");
        minHeapTest.deleteMin();
        System.out.println(minHeapTest);
        
        //Inserting heap from board.
        maxHeapTest.insert(10);
        maxHeapTest.insert(20);
        maxHeapTest.insert(30);
        maxHeapTest.insert(21);
        maxHeapTest.insert(22);
        System.out.println("Max Heap: ");
        System.out.println(maxHeapTest);
        System.out.println("Inserting 6...");
        maxHeapTest.insert(6);
        System.out.println(maxHeapTest);
        System.out.println("Deleting Max...");
        maxHeapTest.deleteMax();
        System.out.println(maxHeapTest);
       
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
