/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexamples.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alcar
 */
public class SyncronizedExample {
    
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
    
    public void doWork(){
        try {
            Thread te1 = new Thread(new Runnable(){
                
                @Override
                public void run(){
                    for(int i = 0; i < 1000; i++) {
                        increment();
                    } //for
                }// run
            });
            
            Thread te2 = new Thread(new Runnable(){
                
                @Override
                public void run(){
                    for(int i = 0; i < 1000; i++) {
                        increment();
                    } //for
                }// run
            });
            
            // Start the Thread and call run method
            te1.start();
            te2.start();
            te1.join();
            te2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SyncronizedExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Count is: " + count);
    }
    
    public static void main(String[] args) {
        SyncronizedExample se = new SyncronizedExample();
        se.doWork();
    }// main
}
