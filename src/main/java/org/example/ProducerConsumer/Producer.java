package org.example.ProducerConsumer;

import java.util.Random;

public class Producer implements Runnable{
    private Container container;
    Integer arithProgression;
    Producer(Container container,Integer progression) throws InterruptedException{
        this.container=container;
        this.arithProgression=progression;
    }

    @Override
    public void run() {
        System.out.println("Inside Producer" );
        Random r = new Random();
        int low = 500;
        int high = 5000;
        int interval=0;
        try {
            while (true) {
                synchronized (this) {
                    for(int i=1;i<30;i++) {
                        this.container.put(arithProgression * i);
                        interval=r.nextInt(high-low) + low;
                        Thread.sleep(interval);
                    }
                }
            }
        } catch (IllegalMonitorStateException e){
            System.out.println("Producer IllegalMonitorStateException occurred");
        }catch(InterruptedException e){
            System.out.println("Producer InterruptedException occurred");
        }
    }
}
