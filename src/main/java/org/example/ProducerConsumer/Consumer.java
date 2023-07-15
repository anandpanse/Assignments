package org.example.ProducerConsumer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class Consumer implements Runnable {

    private Container container;

    Consumer(Container container){
        this.container=container;
    }



    /**
     * This Run Method will use ScheduledExecutorService to control Printing window.
     * Due to future.cancel() ,Printing job will be halted after random time.
     */

    @Override
    public void run(){
        System.out.println("Inside Consumer");
        Integer printingTime=0;
        while(true){
            printingTime = randomPrintWindowTime();
            randomWaitForNextWindow();
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            Future future = executor.submit(new PrintTask(this.container.getIntegerContainer()));
            Runnable cancelTask = () -> future.cancel(true);
            System.out.println("Printing halted after "+printingTime +" MilliSeconds" );
            executor.schedule(cancelTask, printingTime, TimeUnit.MILLISECONDS);
            executor.shutdown();
        }

    }

    /**
     * This Method will create a TimerTask to interrupt the PrinterTask thread upon timeout.
     * TimerTask that takes a Printer thread at the time of its creation.
     * It'll interrupt the Printer thread upon the invocation of its run method.
     */
   /* @Override
    public void run(){
        System.out.println("Inside Consumer");
        Integer printingTime=0;
        Thread thread=null;
        Timer timer=null;
        TimeOutTask timeOutTask=null;
        while(true){
            printingTime = randomPrintWindowTime();
            randomWaitForNextWindow();
            thread = new Thread(new PrintTask(this.container.getIntegerContainer()));
            thread.start();

            timer = new Timer();
            timeOutTask = new TimeOutTask(thread, timer);
            timer.schedule(timeOutTask, printingTime);
            System.out.println("Printing Window Duration is " + printingTime);
        }

    }*/

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

    private static int randomPrintWindowTime() {
        int low = 200;
        int high = 3000;
        int interval=0;
        Random random = new Random();
        interval=random.nextInt(high-low)+low;
        return interval;
    }
}



