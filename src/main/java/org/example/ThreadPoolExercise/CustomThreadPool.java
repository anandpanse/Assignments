package org.example.ThreadPoolExercise;


import java.util.concurrent.LinkedBlockingQueue;

class CustomThreadPool implements ICustomExecutorService {

    static int capacity;
    static int currentCapacity;

    // Creating object of LinkedBlockingQueue class
    // Declaring object of type Runnable
    static LinkedBlockingQueue<Runnable> linkedTaskBlockingQueue;
    Execution e;

    public CustomThreadPool(int capacity)
    {
        this.capacity = capacity;
        currentCapacity = 0;

        // Creating a linked blocking queue which will block
        // if its empty and it will perform thread safe operation.
        linkedTaskBlockingQueue = new LinkedBlockingQueue<Runnable>();
        e = new Execution();
    }

    // Method 2
    // @Override
    public void execute(Runnable r)
    {

        // Declaring and adding tasks to
        // blocking queue using add() method
        linkedTaskBlockingQueue.add(r);

        // executeMyMethod() method of Execution class
        // which will execute the tasks
        e.executeMyMethod();
    }
}
