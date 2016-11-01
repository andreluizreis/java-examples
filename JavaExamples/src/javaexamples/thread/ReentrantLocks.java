/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexamples.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alcar
 */
public class ReentrantLocks {
    
    private static int count = 0;
    private static Lock lock = new ReentrantLock();
    
    private static void increment(){
        for(int i = 0; i < 10000; i++){
            count++;
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        LockThreadExample le = new LockThreadExample();
        
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                lock.lock();
                try {
                    increment();
                } finally{
                    lock.unlock();
                }
            }
        
        });
        
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                lock.lock();
                try {
                    increment();
                } finally{
                    lock.unlock();
                }
            }
        
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();     
        System.out.println("Count = " + count);
    }
}
