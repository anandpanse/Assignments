package org.example.ThreadPoolExercise;

import com.sun.jdi.PathSearchingVirtualMachine;
import org.example.ProducerConsumer.Consumer;
import org.example.ProducerConsumer.Container;
import org.example.ProducerConsumer.Producer;

import java.util.ArrayList;
import java.util.List;

public class ThredPoolMain {

    public static void main(String[] args) throws InterruptedException {
        List<String> taskMsgList=new ArrayList<>();
        taskMsgList.add("Print a Msg");
        taskMsgList.add("Get a coffee");
        taskMsgList.add("Count the Numbers");
        taskMsgList.add("Define a variable");
        taskMsgList.add("Write a method");
        taskMsgList.add("Spawn a Thread");

        TaskThreadPool taskThreadPool=new TaskThreadPool(2,taskMsgList);
        taskThreadPool.execute();


    }


}
