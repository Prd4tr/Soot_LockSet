package com.example.sardsyncmethods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

public class MainActivity extends AppCompatActivity {
    SyncRunnable obj = new SyncRunnable();
    Runnable b = new Runnable(){
        public void  run(){
            HandlerThread child = new HandlerThread("Runc");
            child.start();
            Handler hb = new Handler(child.getLooper());
            hb.post(obj.c);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler(getMainLooper());
        handler.post(obj.a);
        handler.post(b);
    }
}