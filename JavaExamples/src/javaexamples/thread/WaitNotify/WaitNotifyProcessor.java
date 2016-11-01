/*
 * 
 */
package javaexamples.thread.WaitNotify;

import java.util.Scanner;

/**
 * Wait Notify Processor
 * @author Alcar
 */
public class WaitNotifyProcessor {
                
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer thread running ...");
            wait();
            System.out.println("Resumed.");
        }
    }// produce
    
    public void consume() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        
        synchronized(this){
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(4000);
        }
    }// consume
}// class
