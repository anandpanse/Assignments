package org.example.ProducerConsumer;

import java.util.Stack;
import java.util.TimerTask;

public class PrintTask implements Runnable {

    private Stack<Integer> integerContainer;
    public PrintTask(Stack stackToPrint){
        this.integerContainer=stackToPrint;
    }
    @Override
    public void run() {
        while(!integerContainer.empty()){
            System.out.println(integerContainer.pop());
        }
    }
}
