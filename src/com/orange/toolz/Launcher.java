package com.orange.toolz;

import com.orange.toolz.tasks.FIleDataCopyToDBTask;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Launcher {
    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            long startTime = System.currentTimeMillis() / 1000;
            List<Future<Boolean>> results = service.invokeAll(Arrays.asList(new FIleDataCopyToDBTask()));
            for (Future<Boolean> future: results) {
                Boolean result = future.get();
                System.out.println(result);
            }
            long endTime = System.currentTimeMillis() / 1000;

            System.out.println("Import data from file take time" + (endTime - startTime) + " s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
