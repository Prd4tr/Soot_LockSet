package com.example.sardsyncmethods;

public class SyncRunnable {
    Integer p = new Integer(1);
    public synchronized void a1(){
        p = 0;
    }
    public synchronized void c1(){
        p = 10;
    }
    public Runnable a = new Runnable()
    {
        @Override
        public void run() {
            a1();
        }
    };
    public Runnable c = new Runnable()
    {
        @Override
        public void run() {
            c1();
        }
    };
}
