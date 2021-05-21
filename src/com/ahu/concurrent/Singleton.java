package com.ahu.concurrent;

/**
 * 锁、volatile字段、final修饰符与对象的安全发布。其中：第一是锁，锁操作是具备happens-before关系的，
 * 解锁操作happens-before之后对同一把锁的加锁操作。实际上，在解锁的时候，JVM需要强制刷新缓存，
 * 使得当前线程所修改的内存对其他线程可见。第二是volatile字段，
 * volatile字段可以看成是一种不保证原子性的同步但保证可见性的特性，
 * 其性能往往是优于锁操作的。但是，频繁地访问 volatile字段也会出现因为不断地强制刷新缓存而影响程序的性能的问题。
 * 第三是final修饰符，final修饰的实例字段则是涉及到新建对象的发布问题。当一个对象包含final修饰的实例字段时，
 * 其他线程能够看到已经初始化的final实例字段，这是安全的。
 **/
public class Singleton {
    static Singleton instance;

    static Singleton getInstance() {
        //if instance is not volatile or final, there will be a problem in multi threads.
        //操作系统重排new Singleton的指令，可能先返回地址，后init对象。线程A可能在给instance分配了地址，但是在还没初始化之前被切换出去的话，
        //现场B在判断instance == null时候，不为空。因为A赋予的地址，但是没有初始化，所以B获得的对象是空的。
        //对instance加上volatile或者final可以解决，阻止指令重排序。
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}
