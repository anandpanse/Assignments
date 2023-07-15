package org.example.ThreadPoolExercise;

class Mytask implements Runnable {

    String msg;

    public Mytask(String msg) {
        this.msg=msg;
    }
    // @Override
    public void run()
    {
        try {
            // Print and display the current thread using
            // currentThread() method by getting thread name & Task Name
            System.out.println(
                    "Executing Task :-> " + this.msg + " by " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}