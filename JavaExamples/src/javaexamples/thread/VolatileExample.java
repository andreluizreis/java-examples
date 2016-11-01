/*
 * 
 */
package javaexamples.thread;

import java.util.Scanner;


class VolatileProcessor extends Thread {
    
    private volatile boolean running = true;
    
    @Override
    public void run(){
        while(running) {
            System.out.println("Hello");
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {                
            }
        }
    }// run
    
    public void shutdown(){
        running = false;
    }
    
}// class

/**
 *
 * @author Alcar
 */
public class VolatileExample {
    
    public static void main(String[] args){
        
        VolatileProcessor proc1 = new VolatileProcessor();
        proc1.start();
        
        System.out.println("Press return to stop ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();
    }
}
