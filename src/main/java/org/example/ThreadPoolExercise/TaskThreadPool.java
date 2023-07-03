package org.example.ThreadPoolExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreadPool {

    int noOfThreads=2;
    public List<String> taskMsgList;

    public TaskThreadPool(int numberOfThreads,List<String>taskMsgList){
        this.noOfThreads=numberOfThreads;
        this.taskMsgList=taskMsgList;
    }
    public void execute(){
        ExecutorService exService;
         if (this.noOfThreads==1){
             exService= Executors.newSingleThreadExecutor();
         }else{
             exService=Executors.newFixedThreadPool(this.noOfThreads);
         }

         for(String msg:taskMsgList){
             exService.execute(new TaskWorker(this,msg));
         }
         exService.shutdown();
         while(!exService.isTerminated()){
         }

         System.out.println("Thread Task Pool Done");
    }

}
