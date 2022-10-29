package com.orange.toolz;

import com.orange.toolz.models.UserDetail;
import com.orange.toolz.tasks.FIleDataCopyToDBTask;
import com.orange.toolz.tasks.IndexCreatingTask;
import com.orange.toolz.tasks.QueryOperationTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Launcher {
    public static void main(String[] args) {

        /*ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            long startTime = System.currentTimeMillis() / 1000;
            System.out.println("Please keep patients. Task is running. It will take 5-10 min depending upon you hardware");
            List<Future<Boolean>> results = service.invokeAll(Arrays.asList(new FIleDataCopyToDBTask()));
            for (Future<Boolean> future: results) {
                Boolean result = future.get();
                System.out.println(result);
            }
            long endTime = System.currentTimeMillis() / 1000;
            service.shutdown();

            System.out.println("Import data from file take time" + (endTime - startTime) + " s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/


        /*
        *  Creating indexes in the table
        *  for finding fast finding duplicate records
        * */

        /*ExecutorService indexService = Executors.newFixedThreadPool(2);
        ArrayList<IndexCreatingTask> tasks = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            tasks.add(new IndexCreatingTask(i));
        }
        try {
            long startTime = System.currentTimeMillis() / 1000;
            System.out.println("Please keep patients. Index is creating. It will take 5-10 min depending upon you hardware");
            List<Future<ArrayList<Boolean>>> futures = indexService.invokeAll(tasks);
            for (Future future : futures) {
                Boolean reuslt = (Boolean) future.get();
            }
            long endTime = System.currentTimeMillis() / 1000;
            indexService.shutdown();
            System.out.println("Index creation take time" + (endTime - startTime) + " s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        /*
        *  Getting invalid user list
        * */

        ExecutorService invalidUserService = Executors.newFixedThreadPool(1);
        ArrayList<QueryOperationTask> tasks = new ArrayList<>();
        tasks.add(new QueryOperationTask(0));
        try {
            long startTime = System.currentTimeMillis() / 1000;
            System.out.println("Please keep patients. Getting Invalid Users.");
            List<Future<ArrayList<UserDetail>>> futures = invalidUserService.invokeAll(tasks);
            for (Future future : futures) {
                ArrayList<UserDetail> reuslts = (ArrayList<UserDetail>) future.get();
                for (UserDetail detail : reuslts) {
                    System.out.println("Full name : " + detail.getFirstName() + " " + detail.getLastName());
                }
                System.out.println("Invalid user total records : " + reuslts.size());
            }
            long endTime = System.currentTimeMillis() / 1000;
            invalidUserService.shutdown();
            System.out.println("Invalid User operation take time : " + (endTime - startTime) + " s");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
