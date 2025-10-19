package threads;

class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("In run method; thread name is: " + Thread.currentThread().getName());
    }
}

class Worker extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    public MyThread(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        System.out.println(getName());
    }
}

class AnyClass {
    String s ="1";

    synchronized void anyMethod()
    {
        s = s + s;
    }
}

public class Examples {

    public static void main(String args[]) throws InterruptedException {
//        Thread myThread = new ThreadTest();
//        myThread.run(); // #1
//        /*
//        * The correct way to invoke a thread is to call the start() method on a Thread object.
//        * If you directly call the run() method, the method will run just like any other method
//        * (in other words, it will execute sequentially in the same thread without running as a separate thread).
//        * */
//        System.out.println("In main method; thread name is: " + Thread.currentThread().getName());
//
//        Thread.currentThread().setName("Master ");
//        Thread worker = new Worker();
//        worker.setName("Worker ");
//        worker.start();
//        //Thread.currentThread().join();
//        System.out.println(Thread.currentThread().getName());
//        /*
//        * The statement Thread.currentThread() in the main() method refers to the “Master” thread.
//        * Calling the join() method on itself means that the thread waits for itself to complete,
//        * which would never happen, so this program hangs (and does not terminate).
//        * */
//
//        MyThread thread = new MyThread("My_Thread_1.0");
//        thread.start();
//        try
//        {
//            Thread.sleep(1000);
//            // When you call sleep() method, it is currently executing thread which is going to sleep, not on which you have called it.
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//        thread.setName("My_Thread_2.0");
//
//        Thread thread1 = new Thread();
//        thread1.start();
//        Thread.currentThread().setPriority(8);
//        Thread thread2 = new Thread();
//        thread2.start();
//        System.out.println(thread1.getPriority());
//        System.out.println(thread2.getPriority());
//        // thread2 was created after the main thread's priority was set to 8, so it will inherit the priority of 8.
//
//        Thread t3 = new Thread()
//        {
//            @Override
//            public void run()
//            {
//                System.out.println(3);
//            }
//        };
//
//        Thread t2 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    t3.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println(2);
//            }
//        };
//
//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    t2.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(1);
//            }
//        };
//
//        t1.start();
//        t2.start();
//        t3.start();

        AnyClass anyClass = new AnyClass();
        new Thread()
        {
            @Override
            public void run()
            {
                anyClass.anyMethod();
            }
        }.start();

        new Thread()
        {
            @Override
            public void run()
            {
                anyClass.anyMethod();
            }
        }.start();

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println(anyClass.s);

    }
}
