package org.example.ThreadPoolExercise;

class Execution implements Runnable {

        boolean isRunning =true;
        void executeMyMethod() {

        /* At start the current capacity will be 0
        The another capacity is the number of threads we
         want to create so we will increase the current
         capacity count after creating each thread it
         means that we will create the threads if the
         current capacity is less than capacity passed by
         us */

        if (CustomThreadPool.currentCapacity
                < CustomThreadPool.capacity) {
            CustomThreadPool.currentCapacity++;

            // Creating object of Thread class
            Thread t = new Thread(new Execution());

            // Starting the thread
            t.start();
        }
    }

    @Override
    public void run() {
        // Till it is true
        while (isRunning) {
            /* Here fetching the tasks from the linkedblocking queue
             which we have submitted using execute method
             and executing them.
             */
            if (CustomThreadPool.linkedTaskBlockingQueue.size() > 0) {
                Runnable t=CustomThreadPool.linkedTaskBlockingQueue.poll();
                if(t!=null) {
                    t.run();
                }
                if(CustomThreadPool.linkedTaskBlockingQueue.size()<=0){
                    this.isRunning =false;
                }
            }
        }
    }

    public void stop(){

            isRunning =false;

    }
}
