package Heap;

import java.util.Arrays;

/**
 * Implementing a priority queue using a heap.
 * Operations: insert (o(logn)), delMin (o(logn)).
 */
public class Heap {
    private int currentSize; // Keeps track of the index of the last element.
    private int [] heap; // The array that implements the heap.
    
    /**
     * Creates an empty heap with default size of "100".
     */
    public Heap()
    {
        int size = 100; 
        heap = new int [size];
        heap[0] = 0; // Initialize the first index as garbage.
        currentSize = 0; // Skip the first index.
    }
    
    /**
     * Creates an empty heap with the size passed by the user.
     * @param size The size of the heap to be created.
     */
    public Heap(int size)
    {
        heap = new int[size];
        heap[0] = 0;
        currentSize = 0; // Do not count the index "0" as an element.
    }
    
    /**
     * Insert an integer into the heap.
     * @param data The integer to insert into the heap.
     */
    public void insert(int data)
    {
        
        // Insert data at end of the array, unless full then return.
        if(currentSize == heap.length - 1)
        {
            System.out.println("Sorry, the heap is full!");
            return;
        }
        else
        {
            currentSize++;
            heap[currentSize] = data;
        }
        
        // Continue to peroclate up until heap rule is met, or the new "data"
        // node is at the root.
        percolateUp(currentSize);
    }
    
    // Used to percolateUp if heap rule is not met after insertion.
    private void percolateUp(int currentIndex)
    {
        int parentIndex, tmp;
        
        // Continue to percolate up until either heap rule met, or at root.
        while(currentIndex > 1)
        {
            // Calculate the parent of the current element.
            parentIndex = currentIndex / 2;
            
            // If the parent > child, heap rule not followed, swap.
            if(heap[parentIndex] > heap[currentIndex])
            {
                // Swap parent and child.
                tmp = heap[currentIndex];
                heap[currentIndex] = heap[parentIndex];
                heap[parentIndex] = tmp;
                currentIndex = parentIndex; // Update currentIndex.
            }
            else
            {
                break;
            }
        }
    }
    
    /**
     * Delete the minimum element in the heap.
     * @return The minimum element in the heap.
     */
    public int delMin()
    {
        int minValue; // Used to hold the minimum value to return.
        int tmp; // Used for swapping values.
        
        // If the heap is empty, return 0.
        if(currentSize == 0)
        {
            return 0; // Return nothing because there is nothing in the list.
        }
        // If the heap has 1 element, delete it and return it.
        else if(currentSize == 1)
        {
            minValue = heap[1];
            heap[1] = 0;
            currentSize--;
            return minValue;
        }
        
        // Store min value, and swap with right-most leaf (at lowest depth).
        minValue = heap[1];
        heap[1] = heap[currentSize];
        heap[currentSize] = minValue;
        
        // Delete the last element.
        heap[currentSize] = 0; 
        currentSize--;
        
        // Swap if needed until the heap rule is met.        
        percolateDown(1); // Start at root when percolating down.

        return minValue;
    }
    
    private void percolateDown(int currentIndex)
    {
        int lChildIndex, rChildIndex, tmp;
        
        // Grab indicies for both children.
        lChildIndex = currentIndex * 2;
        rChildIndex = (currentIndex * 2) + 1;       
        // Continue to percolate down until at leaf, or heap rule is met.
        while(heap[lChildIndex] > 0)
        {
            // Possibly swap with rChild if rChild is smaller than lChild.
            if(heap[rChildIndex] < heap[lChildIndex])
            {
                // Swap with rChild if it is less than currentIndex, and non-empty,
                // Otherwise heap rule is met, and break.
                if(heap[rChildIndex] < heap[currentIndex]
                        && heap[rChildIndex] > 0)
                {
                    // Swap
                    tmp = heap[rChildIndex];
                    heap[rChildIndex] = heap[currentIndex];
                    heap[currentIndex] = tmp;
                    currentIndex = rChildIndex; // Update index.
                }
                else
                {
                    break;
                }
            }
            // Otherwise, possibly swap with lChild because it is smaller than rChild.
            else
            {
                // Swap if lChild < currentIndex, otherwise heap rule is met
                // and break.
                if(heap[lChildIndex] < heap[currentIndex])
                {
                    // Swap
                    tmp = heap[lChildIndex];
                    heap[lChildIndex] = heap[currentIndex];
                    heap[currentIndex] = tmp;
                    currentIndex = lChildIndex; // Update index.
                }
                else
                {
                    break;
                }
            }
            
            // Update indicies for children.
            lChildIndex = currentIndex * 2;
            rChildIndex = (currentIndex * 2) + 1;
        }
    }
    
    /**
     * Return the heap represented as a string in array form.
     * @return The heap as a string in array form.
     */
    @Override
    public String toString()
    {
        return Arrays.toString(heap);
    }
    
    
}
