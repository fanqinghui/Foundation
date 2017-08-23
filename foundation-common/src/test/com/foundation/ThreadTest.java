package com.foundation;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/8/2 23:00
 */
public class ThreadTest {

    @Test
    public void testFuture() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            futureList.add(service.submit(new Callable<Integer>() {
                /**
                 * Computes a result, or throws an exception if unable to do so.
                 *
                 * @return computed result
                 * @throws Exception if unable to compute a result
                 */
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(1000L);
                    return new Random().nextInt(10000);
                }
            }));
        }

        futureList.stream().forEach((final Future<Integer> future) -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
