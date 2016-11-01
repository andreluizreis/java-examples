/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexamples.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Alcar
 */
public class BlockingQueueThreadExample {
    /**
     * Fields
     */
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    
    /**
     * Producer Method
     * @throws InterruptedException 
     */
    private static void producer() throws InterruptedException{
        Random random = new Random();
        
        while(true){
            Thread.sleep(280);
            Integer value = random.nextInt(99);
            queue.put(value);
            System.out.println("Put = " + value);
        }
    }
    
    /**
     * consumer Method
     * @throws InterruptedException 
     */
    private static void consumer() throws InterruptedException{
        Random random = new Random();
        
        while(true){
            Thread.sleep(100);
            if(random.nextInt(3) == 0){
                Integer value = queue.take();
                System.out.println("Taken = " + value + " ; Queue Size = " + queue.size());
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException ex) {
                }
            } 
        });
        
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    consumer();
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
