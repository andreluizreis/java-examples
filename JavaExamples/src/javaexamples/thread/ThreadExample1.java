/*
 * Extends class Thread
 */
package javaexamples.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alcar
 */
public class ThreadExample1 extends Thread {
        
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Hello  " + i);
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadExample1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }// run
        
    public static void main(String[] args) {
        ThreadExample1 te1 = new ThreadExample1();
        ThreadExample1 te2 = new ThreadExample1();
        
        // Start the Thread and call run method
        te1.start();
        te2.start();
    }// main
}// class
