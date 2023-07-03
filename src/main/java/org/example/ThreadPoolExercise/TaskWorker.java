package org.example.ThreadPoolExercise;

public class TaskWorker implements Runnable{

    private TaskThreadPool taskThreadPool;
    private String msg;
    public TaskWorker(TaskThreadPool taskThreadPool,String msg){
        this.taskThreadPool=taskThreadPool;
        this.msg=msg;
    }

    @Override
    public void run() {
        String threadName="("+Thread.currentThread().getName() + ")";
        System.out.println(threadName+" : "+ this.msg);
        try {
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            System.out.println("In Run Method-Sleep");
        }
       // System.out.println(threadName+this.msg +"Sleep Done");
    }

}
