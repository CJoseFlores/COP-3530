/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Heap.Heap;

public class HeapTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Heap test = new Heap(10);
        
        // Inserting heap from board.
        test.insert(10);
        test.insert(20);
        test.insert(30);
        test.insert(21);
        test.insert(22);
        System.out.println(test);
        
        test.insert(6);
        System.out.println(test);
        //test.delMin();
        //System.out.println(test);
        
    }
    
}
