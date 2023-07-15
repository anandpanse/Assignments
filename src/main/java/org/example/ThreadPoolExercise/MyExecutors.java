package org.example.ThreadPoolExercise;

class MyExecutors {

    // Member variables of this class
    int capacity;

    // Passing the number of threads that
    // will be in the thread pool
    static ICustomExecutorService
    myNewFixedThreadPool(int capacity)
    {
        return new CustomThreadPool(capacity);
    }
}