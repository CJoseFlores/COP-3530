/*********************************************************************
 Purpose/Description: MyList is a List that can push and pop from the front,
                      as well as inject an item to the back.
 Author’s Panther ID: 5160328
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 
 Complexity Explanation:
 * The requirements of the problem says we MUST use the LinkedList class from
 * the Java Standard Library.
 * The description of the "LinkedList" class specifies "All of the operations 
 * perform as could be expected for a doubly-linked list. Operations that index 
 * into the list will traverse the list from the beginning or the end, 
 * whichever is closer to the specified index."
 * This description tells us that it uses a "head" and "tail" pointer.
 * therefore, the "addFirst()" method is O(1) because it simply makes a new node,
 * sets head.next to the new node, and finally sets head as the new node. This
 * is independent of the list size. This means that myPush is O(1).
 * "removeFirst()" is also O(1) because it simply sets head to head.next, therefore
 * myPop() is O(1). Finally, "addLast()" is O(1) because we have a tail pointer,
 * so it simply makes a new node, sets tail.next to the new node, and then 
 * sets tail to the new node; i.e. "myInject()" is O(1).
 * Source: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html 
 ********************************************************************/ 
import java.util.LinkedList;

public class MyList <AnyType> {

    // Using LinkedList as the underlying data structure for "MyList".
    private LinkedList<AnyType> myList;

     /**
      * Constructs an empty MyList object.
      */
     MyList()
     {
         myList = new LinkedList();
     }

     /**
      * Inserts the item x on the front end of the MyList.
      * @param x The item to insert in MyList.
      */
     void myPush(AnyType x)
     {
         myList.addFirst(x);
     }

     /**
      * Removes the front item from the MyList and returns it.
      * @return The item from the front of the list.
      */
     AnyType myPop() 
     {
         return myList.removeFirst();
     }

     /**
      * Inserts the item x on the rear end of the MyList.
      * @param x The item to insert at the end of MyList.
      */
     void myInject(AnyType x)
     {
         myList.addLast(x);
     }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyList someList = new MyList();
        
        // Populate list with values 0 through 5, inserting at the front.
        for(int i = 0; i < 5; i++)
        {
            someList.myPush(i);
        }
        
        System.out.println("Running myPush: " + someList.myList);
        
        // Pop element at the front of the list, and print.
        someList.myPop();
        System.out.println("Popping one item: " + someList.myList);
        
        // Inject an element at the front of the list, and print.
        someList.myInject(20);
        System.out.println("Injecting one item: " + someList.myList);
    }
    

 

    
}
