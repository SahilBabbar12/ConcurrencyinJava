package com.knoldus.Question1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Runnable {
    int number;
    public Task(int number) {
        this.number = number;
    }

    public void run(){
        System.out.println("Number is :"+ number);
    }
}
public class ExecutorDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // creating a new single working thread that will execute 10 tasks
        ExecutorService service= Executors.newSingleThreadExecutor();

        for(int count =0;count<10;count++){
            Future<?> future=service.submit(new Task(count));
            try{
                future.get();
            }catch(Exception e){
                System.out.println(e);
            }

        }
        service.shutdown();
    }
}

