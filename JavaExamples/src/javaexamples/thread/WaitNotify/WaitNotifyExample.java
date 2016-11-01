/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexamples.thread.WaitNotify;

/**
 *
 * @author Alcar
 */
public class WaitNotifyExample {
    
    public static void main(String[] args) throws InterruptedException{
        
        final WaitNotifyProcessor processor = new WaitNotifyProcessor();
        
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException ex) {
                }
            } 
        });
        
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException ex) {
                }
            } 
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }// main
}
