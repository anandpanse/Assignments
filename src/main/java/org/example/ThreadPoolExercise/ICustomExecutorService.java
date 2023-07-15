package org.example.ThreadPoolExercise;


import java.util.concurrent.LinkedBlockingQueue;

interface ICustomExecutorService {
    void execute(Runnable r);
    void shutDown();
}
