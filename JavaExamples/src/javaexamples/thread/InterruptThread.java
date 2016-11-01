/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexamples.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Alcar
 */
public class InterruptThread {
    
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Starting ...");
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        Future<?> fu = executor.submit(new Callable<Void>(){
            @Override
            public Void call() throws Exception {
                Random rand = new Random();
                
                for(int i = 0; i < 1E8; i++){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(rand.nextDouble());
                }
                return null;
            }
            
        });
        
        executor.shutdown();
        Thread.sleep(500);
        
        // Could be true or false. 
        // True = Interrupt even if the thread is already running.
        // False = Interrupt if the Thread is not running. 
        fu.cancel(true); // <-- one way
        
        // The same as Future.cancel(). 
        executor.shutdownNow(); // <-- Another way
        
        executor.awaitTermination(1, TimeUnit.DAYS);
        
        System.out.println("Finished.");
    }
}
