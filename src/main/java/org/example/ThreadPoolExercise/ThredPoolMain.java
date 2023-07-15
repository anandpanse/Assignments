package org.example.ThreadPoolExercise;

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
        taskMsgList.add("Read at least 20 pages per day");
        taskMsgList.add("Buy Grocery ");

        /*Getting the object of MyExcutors by using
         the factory method myNewFixedThreadPool */

        ICustomExecutorService service
                = MyExecutors.myNewFixedThreadPool(3);

        for (String msg:taskMsgList) {
            // Creating tasks and passing them to execute
            service.execute(new Mytask(msg));
        }

    }


}
