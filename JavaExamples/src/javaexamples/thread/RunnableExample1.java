/*
 * Using interface Runnable
 */
package javaexamples.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alcar
 */
public class RunnableExample1 implements Runnable {

    @Override
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
        Thread te1 = new Thread(new RunnableExample1());
        Thread te2 = new Thread(new RunnableExample1());
        
        // Start the Thread and call run method
        te1.start();
        te2.start();
    }// main
    
}// Class
