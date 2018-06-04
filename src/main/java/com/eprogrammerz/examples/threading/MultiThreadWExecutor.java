package com.eprogrammerz.examples.threading;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class MultiThreadWExecutor {
    public List<Future<String>> spawnMultiThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
/*

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executorService.execute(runnableTask);
*/

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = Arrays.asList(callableTask, callableTask, callableTask);

        try {
            return executorService.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        return null;
    }

    @Test
    public void testSpawnMultiThread() {
        List<Future<String>> futures = spawnMultiThread();
        futures.forEach(future -> {
            try {
                assertEquals("Task's execution", future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
