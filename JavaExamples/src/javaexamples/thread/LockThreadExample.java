/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexamples.thread;

import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alcar
 */
public class LockThreadExample {
    
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();
    
    public void produce() throws InterruptedException {
        int value = 0;
        
        while(true){
            
            synchronized(lock){
                
                while(list.size() == LIMIT){
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }            
        }
    }
    
    public void consume() throws InterruptedException {
        Random random = new Random();
        while(true){
            
            synchronized(lock){
                
                while(list.size() == 0){
                    lock.wait();
                }
                System.out.print("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            } 
            Thread.sleep(random.nextInt(1000));
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        LockThreadExample le = new LockThreadExample();
        
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    le.produce();
                } catch (InterruptedException ex) {
                    Logger.getLogger(LockThreadExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
        
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    le.consume();
                } catch (InterruptedException ex) {
                    Logger.getLogger(LockThreadExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();        
    }
}
