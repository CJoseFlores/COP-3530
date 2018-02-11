/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 * 
 * @author carlos
 * @param <E> 
 */
public class LinkedList <E extends Comparable>  {
    
    // Head and tail pointers for the LinkedList.
    private Node head;
    private Node tail;
    
    /**
     * Creates a LinkedList with no elements.
     */
    public LinkedList()
    {
        head = null;
        tail = null;
    }
    
    /**
     * Appends data to the end of the LinkedList.
     */
    public void append(E data)
    {
        Node newNode = new Node(data);
        
        // If the list is empty, point head & tail to newNode, otherwise
        // Only change tail to newNode.
        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.nextNode = newNode;
            tail = newNode;
        }
    }
    
    /**
     * Adds data to the front of the list.
     */
    public void addFirst(E data)
    {
        Node newNode = new Node(data);
        
        // If list is empty, point head & tail to newNode, otherwise, make
        // newNode the new head.
        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.nextNode = head;
            head = newNode;
        }
    }
    
    /**
     * Inserts node when 
     */
    public void addGreaterThan(E data)
    {
        Node newNode = new Node(data);
        Node currentNode = head; // Used to iterate through the list.
        int TESTVALUE;
        
        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            // Iterate through the list until you can place the newNode
            // (the data inside newNode > currentNode.data), or you reach the
            // end of the list.
            while(currentNode != null)
            {
                TESTVALUE = currentNode.data.compareTo(newNode.data);
                if(newNode.data.compareTo(currentNode.data) == 1)
                {
                    // Inserting the newNode after the currentNode since it is
                    // Greater than the currentNode.
                    newNode.nextNode = currentNode.nextNode;
                    currentNode.nextNode = newNode;
                    break;
                }
                else
                {
                    currentNode = currentNode.nextNode; // increment currentNode.
                }
            }
            
        }
        
        
    }
    
    
    
    /**
     * Checks to see if the list is empty.
     * @return A "true" if empty, and a "false" if not empty.
     */
    public boolean isEmpty()
    {
        if(head == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * The list in terms of a list.
     * @return The list as a string.
     */
    @Override
    public String toString()
    {
        Node currentNode = head;
        String listAsString = "(";
        
        while(currentNode != null)
        {
            listAsString = listAsString + currentNode.data + ", ";
            currentNode = currentNode.nextNode;
        }
        
        listAsString = listAsString + ")";
        return listAsString;
    }
    
    
    
    
    
    
    /**
     * Creates a Node that stores data of type "E"
     */
    class Node {
        
    Node nextNode; // Pointer to next node.
    E data; // Data to be stored in node.
    
    /**
     * Creates a Node with data "someData", and points to null.
     * @param someData Some data to store in the node.
     */
    Node(E someData)
    {
        nextNode = null;
        data = someData;
    }
    
    }
    
}
