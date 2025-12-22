package com.fellon.streamapi.task3;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private final int n;

    public FactorialTask(int n) {
        this.n = n;

    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return 1L;
        }

        FactorialTask task = new FactorialTask(n - 1);
        task.fork();
        long result = task.join();
        return result * n;

    }

}