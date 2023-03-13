package com.knoldus.Question2;

public class Counter{
    private static volatile int counter =0;

    public void increment(){
        counter++;
    }

    public int getCount(){
        return counter;
    }

    public static void main(String[] args) {
        Counter incrementCounter = new Counter();

        //main thread that will increment the counter variable.
        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(counter < 10){

                    incrementCounter.increment();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        //printThread that will print the updated value
        Thread printThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (counter < 10){
                    System.out.println("Counter value  changed!" + incrementCounter.getCount() );

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }});

        mainThread.start();
        printThread.start();
    }
}
