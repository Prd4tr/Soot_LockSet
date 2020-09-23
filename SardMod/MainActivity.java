package com.example.sardmod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

public class MainActivity extends AppCompatActivity {
    //Field p = new Field();
    Integer p = new Integer(1);
    Runnable a = new Runnable(){
      public void  run(){
          synchronized (p) {
              p = 10;
          }
      }
    };
    Runnable c = new Runnable(){
        public void  run(){
            synchronized (p) {
                p = 10;
            }
        }
    };
    Runnable b = new Runnable(){
        public void  run(){
            HandlerThread child = new HandlerThread("Runc");
            child.start();
            Handler hb = new Handler(child.getLooper());
            hb.post(c);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler(getMainLooper());
        handler.post(a);
        handler.post(b);
    }
}