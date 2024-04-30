class FooBar {
    private int n;
    volatile boolean isFooTurn = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!isFooTurn) {}
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            isFooTurn = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(isFooTurn) {}
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            isFooTurn = true;
        }
    }
}
