package com.ahu.concurrent;

public class InterruptExample {

    public void interruptCurThread() {

        Thread th = Thread.currentThread();
        while (true) {
            if (th.isInterrupted()) {
                //主动检测中断状态。
                break;
            }
            // 省略业务代码无数
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //InterruptedException - if any thread has interrupted the current thread.
                // The interrupted status of the current thread is cleared when this exception is thrown.
                // 1) 本线程处于waiting,timed_waiting状态时，其他线程调用本线程的interrupt(),会使本线程转为Runnable状态，同时本线程抛出InterruptedException.
                // 2) 本线程处于Runnable状态，且阻塞在java.nio.channels.InterruptedChannel [可中断channel]时，其他线程调用本线程的interrupt(),会使本线程抛出ClosedByInterruptedException。
                // 3) 本线程处于Runnable状态，且阻塞在java.nio.channels.Selector[可多路复用的异步IO机制]上时,本线程会（从Selector.select()）立即返回。
                // 4) 本线程处于Runnable状态，且没有阻塞在某个I/O操作上时，其他线程调用本线程的interrupt(),这只是将本线程的中断标志位置为True。
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
