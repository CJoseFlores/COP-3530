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
        boolean isHeapRuleMet = false; // Checks if the heap rule has been met.
        int currentIndex; // Keep track of the index of the new "data" node.
        int parentIndex; // The index of the parent of the new "data" node.
        int tmp; // Used to hold a value while swapping.
        
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
            currentIndex = currentSize;
        }
        
        // Continue to peroclate up until heap rule is met, or the new "data"
        // node is at the root.
        while(!isHeapRuleMet && currentIndex > 1)
        {
            // Calculate parent index by using the relationship of "i" = parent,
            // "2i" = left child, and "2i+1" = right child.
            if(currentIndex % 2 == 0)
            {
                parentIndex = currentIndex / 2;
            }
            else
            {
                parentIndex = (currentIndex - 1) / 2;
            }
            
            // Swap if parent > child.
            if(heap[parentIndex] > data)
            {
                tmp = heap[parentIndex];
                heap[parentIndex] = data;
                heap[currentIndex] = tmp;
                
                // Update currentIndex to the parent's index since swap was 
                // performed.
                currentIndex = parentIndex;
            }
            else
            {
                isHeapRuleMet = true;
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
        int currentIndex; // Keep track of node that will percolate down.
        int leftChild, rightChild; // Store values for left and right child.
        boolean isHeapRuleMet = false; // Check if the heap rule is met to stop swapping.
        
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
        
        // Delete the last element.
        heap[currentSize] = 0; 
        currentSize--;
        
        currentIndex = 1;
        
        // Swap if needed until the heap rule is met.
        while(!isHeapRuleMet)
        {
            
            // If the children are out of bounds, we are at the end of 
            // the heap, so the rule is met.
            if((currentIndex * 2 > heap.length - 1) || ((currentIndex * 2) + 1) > heap.length - 1)
            {
                break;
            }
             
            // Grab value of left and right child.
            leftChild = heap[currentIndex * 2];
            rightChild = heap[(currentIndex * 2) + 1];
            
            // Check which child is bigger, then swap if needed.
            if(leftChild < rightChild)
            {
                // Percolate down if current element > leftChild.
                if(heap[currentIndex] > leftChild)
                {
                    tmp = heap[currentIndex];
                    heap[currentIndex] = leftChild;
                    heap[currentIndex * 2] = tmp;
                    currentIndex = currentIndex * 2;
                }
                else
                {
                    isHeapRuleMet = true;
                }
            }
            // Right child is larger.
            else
            {
                // Percolate down if current element > rightChild.
                if(heap[currentIndex] > rightChild)
                {
                    tmp = heap[currentIndex];
                    heap[currentIndex] = rightChild;
                    heap[(currentIndex * 2) + 1] = tmp;
                    currentIndex = (currentIndex * 2) + 1;
                }
                else
                {
                    isHeapRuleMet = true;
                }
            }
        }
        
        
        
        
        return minValue;
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
