/**
 * Count Down Latch Example
 */
package javaexamples.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Count Down Latch Example
 */

class Processor implements Runnable {

    private CountDownLatch latch;
    
    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }
    
    @Override
    public void run() {
        
        System.out.println("started");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {            
        }
        latch.countDown();
    }// run
    
    
}// Processor class

/**
 *
 * @author Alcar
 */
public class CountDownLatchExample {
    
     public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for(int i = 0; i < 3; i++){
            executor.submit(new Processor(latch));
        }
        try{
            latch.await();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
         System.out.println("Completed.");
     }// main     
}// class
