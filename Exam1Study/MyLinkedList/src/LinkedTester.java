/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import LinkedList.LinkedList;
/**
 *
 * @author carlos
 */
public class LinkedTester {
    
    
    
    public static void main(String [] args){
        
        LinkedList test = new LinkedList<Integer>();
        
        for(int i = 0; i < 5; i++)
        {
            test.append(i);
        }
        
        System.out.println(test);
        
        test.addGreaterThan(3);
        
        test.addFirst(10);
        
        System.out.println(test);
        
    }
    
}
