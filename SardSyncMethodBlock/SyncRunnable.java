package com.example.sardsyncmethodblock;

public class SyncRunnable {
    public Integer p = new Integer(1);
    public synchronized void runa(){
        p = 0;
    }
    public Runnable a = new Runnable()
    {
        @Override
        public void run() {
            runa();
        }
    };
}
