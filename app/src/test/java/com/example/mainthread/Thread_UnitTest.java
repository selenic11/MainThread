package com.example.mainthread;

import org.junit.Test;

public class Thread_UnitTest {

    class Work extends Thread {
        String name;

        public  Work(String name) {
            this.name = name;
        }

        public void print(){
            System.out.println(name);
        }

        @Override
        public void run() {
            synchronized (name){
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(((long)(Math.random())));
                        System.err.println("Thread " + name + " is not sleep!");

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            print();
            //System.err.println(name + " in thread!!!");
        }
    }


    @Test
    public void test(){
        Work work1 = new Work("A");
        Work work2 = new Work("B");
        Work work3 = new Work("C");
        Work work4 = new Work("D");

        work1.start();
        work2.start();
        work3.start();
        work4.start();
    }

}
