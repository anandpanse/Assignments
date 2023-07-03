package org.example.ProducerConsumer;

import java.util.Random;

public class Consumer implements Runnable {

    private Container container;
    Consumer(Container container){
        this.container=container;
    }
    @Override
    public void run() {
        System.out.println("Inside Consumer");

            while (true) {
                try {
                    synchronized (this) {
                        randomWaitForNextWindow();
                        printNumbers();
                    }
                } catch(IllegalMonitorStateException e) {
                    System.out.println("Consumer IllegalMonitorStateException Occurs");
                }catch(InterruptedException e){
                    System.out.println("Consumer Sleep Interrupted");
                }
            }
            }

    /**
     *
     * @throws InterruptedException
     */
    private void printNumbers() throws InterruptedException {
        while(container.getIntegerContainer().size()>0) {
            System.out.println(container.take());
            Thread.sleep(500);
        }
        System.out.println("Waiting for Next Print Window...."+Thread.currentThread().getName());
    }

    private static void randomWaitForNextWindow() {
        int low = 6000;
        int high = 10000;
        int interval=0;
        Random random = new Random();
        try {
            interval=random.nextInt(high-low)+low;
            //System.out.println("Time Delay for next print window:-"+interval);
            Thread.sleep(interval);
        } catch(InterruptedException e) {
            System.out.println("Consumer -Sleep Window Interrupted ");
        }
    }
}



