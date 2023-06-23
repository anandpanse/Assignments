
package org.example.ProducerConsumer;

public class producerConsumer {

    public static void main(String[] args) throws InterruptedException {
        Container container=new Container();
        Producer p3=new Producer(container,7);
        Producer p5=new Producer(container,5);
        Consumer c1=new Consumer(container);


        Thread firstProducer=new Thread(p3);
        Thread secondProducer=new Thread(p5);
        Thread firstConsumer=new Thread(c1);

        firstProducer.start();
        secondProducer.start();
        firstConsumer.start();

    }
}
