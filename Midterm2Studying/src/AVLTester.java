/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos
 */
import AVLTree.AVLTree;

public class AVLTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AVLTree testTree = new AVLTree();
        System.out.println("Empty Tree: " + testTree);
        
        testTree.insert(0);
        System.out.println(testTree);
        
        testTree.insert(1);
        System.out.println(testTree);
        
        testTree.insert(2);
        System.out.println(testTree);
        
        testTree.insert(3);
        testTree.insert(8);
        testTree.insert(5);
        
        testTree.printTree();
    }
    
}
