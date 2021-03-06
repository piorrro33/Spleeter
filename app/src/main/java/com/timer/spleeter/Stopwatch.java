package com.timer.spleeter;

import android.os.SystemClock;

public class Stopwatch {
    private boolean isRunning;
    private long savedTime;
    private long startTime;

    Stopwatch(){
        isRunning = false;
        savedTime = 0;
    }

    synchronized public void start(){
        startTime = SystemClock.elapsedRealtime();
        isRunning = true;
    }

    synchronized public void stop(){
        if(isRunning){
            savedTime += SystemClock.elapsedRealtime() - startTime;
            isRunning = false;
        }
    }

    synchronized public void reset(){
        savedTime = 0;
        isRunning = false;
    }

    synchronized public int getTimeInTenths(){
        return (int)(getTime()/100);
    }

    synchronized public long getTime(){
        if(!isRunning){
            return savedTime;
        } else {
            return savedTime + SystemClock.elapsedRealtime() - startTime;
        }
    }
}
