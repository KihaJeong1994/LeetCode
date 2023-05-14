class Foo {
    private boolean done1,done2;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(this){
            printFirst.run();
            notifyAll();
            done1=true;
        }
        
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(this){
            while(!done1){
                wait();
            }
            printSecond.run();
            done2=true;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(this){
            while(!done2){
                wait();
            }
            printThird.run();
            notifyAll();
        }
    }
}