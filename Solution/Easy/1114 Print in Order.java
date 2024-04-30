class Foo {
    private volatile boolean firstCompleted = false;
    private volatile boolean secondCompleted = false;

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstCompleted = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(!firstCompleted) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondCompleted = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(!secondCompleted) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
