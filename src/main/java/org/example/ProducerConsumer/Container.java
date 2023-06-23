package org.example.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Container {
    public Stack<Integer> getIntegerContainer() {
        return integerContainer;
    }
    private Stack<Integer> integerContainer;
    Container(){
        integerContainer=new Stack<Integer>();
    }

    public  synchronized void put(Integer element){
        if(element!=null){
            this.getIntegerContainer().push(element);
        }
    }

    public synchronized Integer take(){
            return this.getIntegerContainer().pop();
    }
}
